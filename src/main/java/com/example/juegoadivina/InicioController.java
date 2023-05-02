package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {
    private Stage stage;
    private Scene scene;

    public void JugarHistoria(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HistoriaView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void VerInstrucciones(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InstruccionesView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void VerRanking(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RankingGeneralView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}