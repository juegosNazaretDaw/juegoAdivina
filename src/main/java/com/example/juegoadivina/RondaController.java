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
import java.util.ArrayList;

import static com.example.juegoadivina.CantidadJugadoresController.idRonda;
import static com.example.juegoadivina.CantidadJugadoresController.jugadoresPartida;


public class RondaController {

    Stage stage;
    Scene scene;

    @FXML
    private Label nombreJugador;

    @FXML
    private PasswordField numeroElejido;

    ArrayList<Integer> numerosElejidosRonda; //lista de los numeros elejidos de los jugadores vivos en la ronda

    int i;

    @FXML
    public void initialize() {
        idRonda++;
        i = 0;
        changeLabelNombre();
    }

    @FXML
    void jugadorSiguiente(ActionEvent event) {
        //pasar a la pagina de resultadoRonda if (!(i < jugadoresPartida.size()))
        metodo(event);


    }

    public void changeLabelNombre() {
        //cambiar el label al nombre del jugador actual
        nombreJugador.setText(jugadoresPartida.get(i).getNombre());
    }

    void metodo(ActionEvent event) {
        //make sure the number is valid
        if (Integer.parseInt(numeroElejido.getText()) < 1 || Integer.parseInt(numeroElejido.getText()) > 100 || numeroElejido.getText().isEmpty()) {

            //guardad el numero elejido en el arraylist 'numerosElejidos' del jugador actual
            jugadoresPartida.get(i).numerosElejidos.add(Integer.valueOf(numeroElejido.getText()));

            //contador para el siguiente jugaodor (si es vivo sino el siguiente)
            do {
                i++;
            } while (!jugadoresPartida.get(i).esVivo());

            //ver cual seria la pagina siguiente jugadorSiguiente o rondaResultado
            if (i < jugadoresPartida.size()) { //para pasar al siguiente jugador
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


        Parent root = FXMLLoader.load(getClass().getResource("RondaResultadoView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public double calcularResto() {
      //calcular el numero para saber quien es el mas cercano a este numero

        //gandor es el mas cercano al resultado --> se puede hacer a partir de Math.min(dif1, dif2, dif3 ..)
        //       dif se calcula con result menos el numeroAdivinado -- mejor hacer el valor absoluto
        numerosElejidosRonda = new ArrayList<>();
        int suma = 0; // la suma de los numeros adivinados
        for (int j = 0; j < jugadoresPartida.size(); j++) { //bouclear a todos los jugadores de la partida
            if (jugadoresPartida.get(i).esVivo()) { //ver solamete quien es vivo
                numerosElejidosRonda.add(jugadoresPartida.get(i).getNumeroElejedo(idRonda)); //guardar el numero elejido de esta ronda
                suma += jugadoresPartida.get(i).getNumeroElejedo(idRonda);
            }
        }
        double restoRonda = suma / numerosElejidosRonda.size() * 0.8;
        return restoRonda;
    }

    public ArrayList<Double> getDiferencias() {
        //devolver un arrayList<Double> de las diferencias entre los numeros adivinados de la ronda con el restoRonda
        ArrayList<Double> diferencias = new ArrayList<>();

        for (int j = 0; j < numerosElejidosRonda.size(); j++) {
            double dif = calcularResto() - numerosElejidosRonda.get(j);
            diferencias.add(Math.abs(dif));
        }
        return diferencias;
    }

    public void changeVidas() {

    }




}

//the first thing is the control of the input
//guardar el numero elejido del jugador
//ver si pasar a la jugador siguiente o al resultado -> if (!(i < jugadoresPartida.size()))

