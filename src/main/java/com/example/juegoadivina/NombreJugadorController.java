package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NombreJugadorController {
    //despues de tener la cantidad, crear una lista de jugadores cada uno con su nombre
    //en jugador X : X empieza desde 1 hasta cantidad (i <= cantidad)


    private Stage stage;
    private Scene scene;

    public static int numereoJugadorActual; //para mostrarlo en la pantalla (en el label numeroJugador)

    @FXML
    private Label numeroJugador;
    @FXML
    private TextField nombreJugadorTF;

    @FXML
    private PasswordField passwordJugadorTf;

    @FXML
    public void initialize() {
        //mejor llamar a un metodo aqui que devuelve el numero de jugador
        numeroJugador.setText(getNumereoJugadorActual());
        System.out.println("test 1");
    }

    @FXML
    public void VolverElegirJugadores(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CantidadJugadoresView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void jugadorSiuiente(ActionEvent event) throws IOException {
        if (numereoJugadorActual < CantidadJugadoresController.cantidadJugadores) {
            //completar la lista de jugadores - pasar a la pagina de sacar el nombre del seguinte jugador

            //reset el textfield
            nombreJugadorTF.setText("");

            //sumar el numero de jugador actual
            numeroJugador.setText(getNumereoJugadorActual());

        } else {
            //cuando estamos en la pagina del ultimo jugador -> pasar al juego
            Parent root = FXMLLoader.load(getClass().getResource("RondaView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public String getNumereoJugadorActual() {
        numereoJugadorActual++;
        return String.valueOf(numereoJugadorActual);
    }

}
