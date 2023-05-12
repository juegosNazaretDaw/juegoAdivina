package com.example.juegoadivina;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyObjectWrapper;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.juegoadivina.CantidadJugadoresController.idRonda;
import static com.example.juegoadivina.CantidadJugadoresController.jugadoresPartida;
import static com.example.juegoadivina.RondaController.cantidadVivosRonda;

public class RondaResultadoController {

    Stage stage;
    Scene scene;

    @FXML
    private Label idRondaLabel;

    @FXML
    private TableView<JugadorPartida> tableView;

    @FXML
    private TableColumn<JugadorPartida, String> jugadorColumn;

    @FXML
    private TableColumn<JugadorPartida, Integer> vidasColumn;

    @FXML
    private TableColumn<JugadorPartida, Integer> numeroElegidoColumn;

    @FXML
    private Label resultadoLabel;

    ObservableList<JugadorPartida> jugadoresRondaObservable = FXCollections.observableArrayList(getJugadoresRondaArray());

    public void initialize() {
        // Set up the cell value factory for jugadorColumn using a Callback
        jugadorColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JugadorPartida, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<JugadorPartida, String> param) {
                JugadorPartida jugador = param.getValue();
                String nombre = jugador.getNombre();
                return new ReadOnlyObjectWrapper<>(nombre);
            }
        });

        // Set up the cell value factory for vidasColumn using a Callback
        vidasColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JugadorPartida, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<JugadorPartida, Integer> param) {
                JugadorPartida jugador = param.getValue();
                int vidas = jugador.getVidas();
                return new ReadOnlyObjectWrapper<>(vidas);
            }
        });

        // Set up the cell value factory for numeroElegidoColumn using the previous method
        numeroElegidoColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JugadorPartida, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<JugadorPartida, Integer> param) {
                JugadorPartida jugador = param.getValue();
                int numeroElegido = jugador.getNumeroElegido();
                return new ReadOnlyObjectWrapper<>(numeroElegido);
            }
        });

        // Set the items of the table view
        tableView.setItems(jugadoresRondaObservable);
    }

    @FXML
    void siguientePortada(ActionEvent event) throws IOException {
        //ver si hay mas de un jugador vivo
        if (cantidadVivosRonda() > 1) {
            toRonda(event);
        } else {
            toResultadoPartida(event);
        }
    }

    void toRonda(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RondaView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void toResultadoPartida(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RankingPartidaView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public ArrayList<JugadorPartida> getJugadoresRondaArray() {
        //devuelve una arraylist<JugadorPartida> de los quien han jugado la ronda (la ultima ronda)
        ArrayList<JugadorPartida> JugadoresRondaArray = new ArrayList<>();

        for (int i = 0; i < jugadoresPartida.size(); i++) {
            //ver el jugador ha jugado en la ronda
            if (idRonda+1 == jugadoresPartida.get(i).cantidadRondas()) {
                JugadoresRondaArray.add(jugadoresPartida.get(i));
            }
        }
        return JugadoresRondaArray;
    }



}
//mostrar el resultado a partir de ver la cantidad de rondas que tiene el jugador con el idRonda