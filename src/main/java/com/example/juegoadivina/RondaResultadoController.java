package com.example.juegoadivina;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RondaResultadoController {


    @FXML
    private TableView<Jugador> jugadorTableView;
    @FXML
    private TableColumn<Jugador, String> jugadorColumn;
    @FXML
    private TableColumn<Jugador, Integer> vidasColumn;
    @FXML
    private TableColumn<Jugador, Integer> numeroElejidoColumn;

    private ObservableList<JugadorPartida> jugadoresRonda = FXCollections.observableArrayList();


}
