package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class NombreJugadorController {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label numeroJugador;

    @FXML
    public void VolverElegirJugadores(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CantidadJugadoresView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void ElegirNumero(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RondaView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
