package com.example.juegoadivina;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.juegoadivina.CantidadJugadoresController.*;

public class RankingPartidaController {

    Stage stage;
    Scene scene;

    MongoCon mongoCon;


    @FXML
    private TableView<JugadorPartida> tableView;

    @FXML
    private TableColumn<JugadorPartida, String> jugadorColumn;

    @FXML
    private TableColumn<JugadorPartida, Integer> puntosColumn;

    ObservableList<JugadorPartida> jugadoresPartidaObservable = FXCollections.observableArrayList(CantidadJugadoresController.jugadoresPartida);

    @FXML
    public void initialize() {

        jugadorColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JugadorPartida, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<JugadorPartida, String> param) {
                JugadorPartida jugador = param.getValue();
                String nombre = jugador.getNombre();
                return new ReadOnlyObjectWrapper<>(nombre);
            }
        });


        // Set up the cell value factory for vidasColumn using a Callback
        puntosColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<JugadorPartida, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<JugadorPartida, Integer> param) {
                JugadorPartida jugador = param.getValue();
                int vidas = jugador.getVidas();
                return new ReadOnlyObjectWrapper<>(vidas);
            }
        });

        tableView.setItems(jugadoresPartidaObservable);

        //actualizar los datos en la base de datos
        insertToDB();

    }


    @FXML
    void replay(ActionEvent event) throws Exception {
        //volver a jugar con los mismos jugadores

        //reset everything except la lista de Jugadores despues pasar ala portada del juego directamente (crear lista de jugadorePartida antes)

        idRonda = -1;
        //reset jugadoresPartida
        jugadoresPartida = null;
        jugadoresPartida = new ArrayList<>();
        //rellena jugadoresPartida a partir de la lista de jugadores que tenemos
        NombreJugadorController.fillJugadoresPartida();

    }

    @FXML
    void volver(ActionEvent event) throws IOException {
        //reboot the whole application to reset everything
//        InicioApplication.rebootApplication(); //he comentado esto porque me da error

        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void insertToDB() {
        //insertar los datos en la base de datos

        //antes de insertar los cambios de los jugadores -> actualiza la lista de jugadores despues de la partida
        updateJugadoresArray();

        //insertar en la base de datos los cambios que hay
        updateJugadorCollection();

        //add a method to insert the partida and Rondas values to the DB

        //update the ranking according to the puntos of every Jugador
        mongoCon.updateRanking();
    }

    void updateJugadoresArray() {
        /* actualizar la lista de jugadores
        *   - sumar la cantidad de partidas jugadas para todos
        *   - sumar la cantidad de partidas ganadas para el ganador
        *   - sumar la cantidad de puntos a partir de las vidas que le queda
        * */

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).addPartidaJugada();

            //sumar partidas ganadas y punto, solo para el ganador
            if (jugadoresPartida.get(i).esVivo()) {
                //solamente el ganador quien va estar vivo con una vida o mas
                jugadores.get(i).addPartidaGanadas();
                jugadores.get(i).addPuntos(jugadoresPartida.get(i).getVidas());
            }
        }
    }

    void updateJugadorCollection() {
        //actualizar los campos de cada jugador en la base de datos
        for (int i = 0; i < jugadores.size(); i++) {
            mongoCon.updateJugador(jugadores.get(i));
        }
    }

}
