package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HistorialPartidasController {

    private Stage stage;
    private Scene scene;


    @FXML
    public void VolverPrincipio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
