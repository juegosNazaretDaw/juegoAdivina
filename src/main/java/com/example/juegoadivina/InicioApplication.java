package com.example.juegoadivina;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InicioApplication.class.getResource("InicioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Escapa de la isla");
        stage.setScene(scene);
        stage.show();
    }

//    public void rebootApplication() { //comentar para no tener problemas
//        Platform.runLater(() -> {
//            try {
//                stop(); // Stop the current application
//                start(new Stage()); // Start a new instance of the application
//            } catch (Exception e) {
//                // Handle any exceptions
//                e.printStackTrace();
//            }
//        });
//    }

    public static void main(String[] args) {
        launch();
    }
}