package com.example.juegoadivina;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CantidadJugadoresController {
    private Stage stage;
    private Scene scene;

    public static int cantidadJugadores;
    public static int idRonda = -1;

    public static ArrayList<Jugador> jugadores = new ArrayList<>(); //donde se guardan los jugadores
    public static ArrayList<JugadorPartida> jugadoresPartida = new ArrayList<>(); //donde se guardan los jugadores de la partida

    @FXML
    private TextField cantidadJugadoresTF;

    @FXML
    private Label errorMessage;


    @FXML
    public void initialize() {
        //reset the static data
        idRonda = -1;
        jugadores = new ArrayList<>();
        jugadoresPartida = new ArrayList<>();
    }


    @FXML
    public void Volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void ElegirNombres(ActionEvent event) throws IOException {
        //pasar al la pagina de nombres de cada jugador

        //si la cantidad es valida pasar al siguiente pagina sino mostrar el mensaje derror (set it visible)
        if (validarCantidad(cantidadJugadoresTF.getText())) {

            //guardar la cantidad de jugadores como atributo
            cantidadJugadores = Integer.parseInt(cantidadJugadoresTF.getText());

            //oculta el mensaje d error en caso de si estaba visible
            errorMessage.setVisible(false);


            Parent root = FXMLLoader.load(getClass().getResource("NombreJugadorView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);


            stage.show();
        } else {
            errorMessage.setVisible(true);
        }
    }

    public boolean validarCantidad(String input) {
        //devuelve false si el inout no es un intero positivo

        if ((!input.matches("\\d+")) || (Integer.parseInt(input) < 2 )) {
            return false;
        } else {
            return true;
        }
    }


}