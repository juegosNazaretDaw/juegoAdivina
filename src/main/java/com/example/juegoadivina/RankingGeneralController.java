package com.example.juegoadivina;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RankingGeneralController {

    Stage stage;
    Scene scene;

    @FXML
    private TableColumn<Jugador, String> nombreColumn;

    @FXML
    private TableColumn<Jugador, Integer> pGanadasColumn;

    @FXML
    private TableColumn<Jugador, Integer> pJugadasColumn;

    @FXML
    private TableColumn<Jugador, Integer> puntosColumn;

    @FXML
    private TableColumn<Jugador, Integer> rankingColumn;

    @FXML
    private TableView<Jugador> tableView;

    private MongoCon mongoCon;

    @FXML
    public void initialize() {
        mongoCon = new MongoCon();
        initializeTableColumns();
        populateTableView();
    }

    private void initializeTableColumns() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        pGanadasColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPartidasGanadas()).asObject());
        pJugadasColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPartidasJugadas()).asObject());
        puntosColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPuntos()).asObject());
        rankingColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getRanking()).asObject());
    }

    private void populateTableView() {
        List<Jugador> jugadores = mongoCon.getAllJugadores();
        tableView.getItems().addAll(jugadores);
    }


    @FXML
    void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}