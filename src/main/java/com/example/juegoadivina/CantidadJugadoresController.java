package com.example.juegoadivina;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CantidadJugadoresController {
    private Stage stage;
    private Scene scene;

    @FXML
    public void VolverHistoria(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HistoriaView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void ElegirNombres(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NombreJugadorView.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}