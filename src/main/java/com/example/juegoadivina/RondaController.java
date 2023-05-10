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
        if (Integer.parseInt(numeroElejido.getText()) < 1 || Integer.parseInt(numeroElejido.getText()) > 100) {

            //ver cual seria la pagina siguiente jugadorSiguiente o rondaResultado
            if (i < jugadoresPartida.size()) { //para pasar al siguiente jugador

                //guardad el numero elejido en el arraylist 'numerosElejidos' del jugador actual
                jugadoresPartida.get(i).numerosElejidos.add(Integer.valueOf(numeroElejido.getText()));

                //contador para el siguiente jugaodor
                i++;

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
        Parent root = FXMLLoader.load(getClass().getResource("RondaResultadoView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void toRankingPartida(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("RankingPartidaView.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}

//the first thing is the control of the input
//guardar el numero elejido del jugador
//ver si pasar a la jugador siguiente o al resultado -> if (!(i < jugadoresPartida.size()))

