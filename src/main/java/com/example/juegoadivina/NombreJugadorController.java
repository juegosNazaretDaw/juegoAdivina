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


    /* add the control : (fields are filled with correct value)
    * check the username and password with the database
    *   if the user exists
    *       check if the password is good
    *   if the user doesn't exist
    *       create a jugador from this username and its password
    *
    * add encryption to the password
    *   */

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

    public void jugadorSiuiente(ActionEvent event) throws IOException {
        //true -> ir a la pagina del siguiente jugador
        //false -> ir a la pagina de juego (RondaView)
        if (CantidadJugadoresController.cantidadJugadores != CantidadJugadoresController.jugadoresPartida.size()) {
            //reset el textfield y el passwordField
            nombreJugadorTF.setText("");
            passwordJugadorTf.setText("");

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
        //sumar el numero de jugador actual y devolverlo como String
        numereoJugadorActual++;
        return String.valueOf(numereoJugadorActual);
    }

    @FXML
    public void signInMethod(ActionEvent actionEvent) throws IOException {
        //get the nombreField y passwordField y ver si existe el usuario y la contraseña esta bien hecha sino mostrar el mensaje d error
        //password has to be encrypted before making the query
        //guardar el jugador a la lista de los jugadores de la partida y pasar a la siguiente pagina (que puede ser el proximo jugador o al juego)

        //make a method para cambiar the Scene en vez de hacerelo 2 veces (in signIn y SignUp)

        if (true) //chage the true here with : if(isUserPassValid(nombre, pswd))
        {
            // get all the info of this user from the query's result and save it to arraylist jugadoresPartida

            //crear una funcion que devuelve un objeto del jugador actual a partir del resultado de la query
//            JugadorPartida jugadorPartida = getJugadorObject(queryResult);

            //añadir este jugador a la lista de los jugadores de la partida
//            CantidadJugadoresController.jugadoresPartida.add(jugadorPartida);

            //pasar a la otra pagina : mejotr que se hace a partir de llamar a un metodo que lo hace
            jugadorSiuiente(actionEvent);

        } else {
            //error message -- labelError.setText("wrong name or password")
            System.out.println("labelError.setText('wrong name or password')");
        }

    }

    @FXML
    public void signUpMethod(ActionEvent actionEvent) throws IOException {
        //get the fields, ver si el nombreJugador no existe , insert el jugador en la base de datos y tambien en la partida

        if (true) //chage the true here with : if(isUserPassValid(nombre, pswd)) -> no user with this name
        {
            //crear objeto de este jugador
//            JugadorPartida jugadorPartida = new JugadorPartida(nombreTF, PasswordTF);

            //llamar a un metodo para insertar el jugador a la base datos
            //look for how to get the father object of JugadorPartida which is Jugador
//            saveToDB(jugador);

            //añadir este jugador a la lista de los jugadores de la partida
//            CantidadJugadoresController.jugadoresPartida.add(jugadorPartida);

            //pasar a la otra pagina : mejotr que se hace a partir de llamar a un metodo que lo hace
            jugadorSiuiente(actionEvent);
        }
     }
}
