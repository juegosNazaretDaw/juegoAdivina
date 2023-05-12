package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.juegoadivina.CantidadJugadoresController.idRonda;
import static com.example.juegoadivina.CantidadJugadoresController.jugadoresPartida;


public class RondaController {

    Stage stage;
    Scene scene;

    @FXML
    private Label nombreJugador;

    @FXML
    private PasswordField numeroElejido;

    int i;

    @FXML
    public void initialize() {
        idRonda++;
        i = -1; //contador para el siguiente jugaodor (si es vivo sino el siguiente)
        //he puesto esta parte del codigo aqui para evitar errores si el primer Jugador en la lista esta muerto
        try {
            do {
                i++;
            } while (!jugadoresPartida.get(i).esVivo());
        } catch (ArrayIndexOutOfBoundsException e) { //add the control para evitar este error
        }
        changeLabelNombre();
    }

    @FXML
    void jugadorSiguiente(ActionEvent event) {
        //pasar a la pagina de resultadoRonda if (!(i < jugadoresPartida.size()))
        metodoPrinciapl(event);


    }

    public void changeLabelNombre() {
        //cambiar el label al nombre del jugador actual
        nombreJugador.setText(jugadoresPartida.get(i).getNombre());
    }

    void metodoPrinciapl(ActionEvent event) {
        //este metodo guarda el numeroAdivinado despues de controlarlo y controla a que portada pasar (jugadorSiguiente o rondaResultado)

        //make sure the number is valid
        if (Integer.parseInt(numeroElejido.getText()) < 1 || Integer.parseInt(numeroElejido.getText()) > 100 || numeroElejido.getText().isEmpty()) {

            //guardar el numero elejido en el arraylist 'numerosElejidos' del jugador actual
            jugadoresPartida.get(i).numerosElegidos.add(Integer.valueOf(numeroElejido.getText()));

            //contador para el siguiente jugaodor (si es vivo sino el siguiente)
            try {
                do {
                    i++;
                } while (!jugadoresPartida.get(i).esVivo());
            } catch (ArrayIndexOutOfBoundsException e) { //add the control para evitar este error
            }

            //ver cual seria la pagina siguiente jugadorSiguiente o rondaResultado
            if (i < cantidadVivosRonda()) { //para pasar al siguiente jugador
                //cambiar el nombre label
                changeLabelNombre();

                //reset el field de numero elejido
                numeroElejido.setText("");
            } else {
                //para pasar a la pagina de resultado ronda
                try {
                    toResultadoRonda(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            //set a label error
            System.out.println("el numero esta mal ");
        }
    }

    public void toResultadoRonda(ActionEvent event) throws IOException {
        //antes de pasar - ver quien ha ganado
        setGanadorRonda();
        //quitar vida de los demas (solo los vivos)
        changeVidas();

        //pasar al portada rondaResultado
        Parent root = FXMLLoader.load(getClass().getResource("RondaResultadoView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //en resultado ronda, ver si hay mas de un vivo -> ronda mas, sino al resultado del partida
    }

    public double calcularResto() {
      //calcular el numero para saber quien es el mas cercano a este numero

        //calcular la suma de los numeros adivinados
        int suma = 0; // la suma de los numeros adivinados
        for (int j = 0; j < jugadoresPartida.size(); j++) { //bouclear a todos los jugadores de la partida
            if (jugadoresPartida.get(i).esVivo()) { //ver solamete quien es vivo
                suma += jugadoresPartida.get(j).getNumeroElegido();
            }
        }
        //calcular el resto
        double restoRonda = suma / cantidadVivosRonda() * 0.8;
        return restoRonda;
    }

    void setGanadorRonda() {
        //cambiar el atributo masCercano a true del jugador quien esta mas cercano
        double min = 100;
        int posMin = 100; //posicion del jugador mas cercano
        for (int j = 0; j < jugadoresPartida.size(); j++) {
            if (jugadoresPartida.get(j).esVivo()) { //solamento los vivos
                double dif = calcularResto() - jugadoresPartida.get(j).getNumeroElegido(); //get la difernecia
                if (Math.abs(dif) < min) { //ver si esta diferencia es la la minima
                    //si la diferencia es menor que min -> es la minima ahora
                    min = Math.abs(dif);
                    posMin = j; // guardar la posicion de este jugador para camabiarle el attrinuto masCercano despues de salir del boucle
                }
            }
        }
        //cambiar el atributo masCercano a true para el jugador con la diferencia minima
        jugadoresPartida.get(posMin).masCercano = true;
    }

    public void changeVidas() {
        //este metodo cambia las vidas despues de cada partida
        //se cambia a todos quienes son vivos excepto el masCercano (quien tiene el attributo masCercano  = true)

        for (int j = 0; j < jugadoresPartida.size(); j++) {
            if (jugadoresPartida.get(j).esVivo()) {
                if (!jugadoresPartida.get(j).masCercano) {
                    jugadoresPartida.get(j).quitarVida();
                }
            }
        }
        // despues de quitar las vidas -> reset the masCercano attribute para todos los jugadores
        resetMasCercano();

    }

    public void resetMasCercano() {
        //reset MasCercano attribute para todos los jugadores  a partir  de asignar masCercano = false
        for (int j = 0; j < jugadoresPartida.size(); j++) {
            jugadoresPartida.get(j).masCercano = false;
        }
    }

    public static int cantidadVivosRonda() {
        int cantidadVivos = 0; //la cantidad de los jugadores vivos en la ronda
        for (int j = 0; j < jugadoresPartida.size(); j++) {
            cantidadVivos++;
        }
        return cantidadVivos;
    }

}

