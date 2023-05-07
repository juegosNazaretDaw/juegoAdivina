package com.example.juegoadivina;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/*Comments of this class
 * - make the "volver" method reset all the data (the numeroJugador too)
 * -
 * */

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

    @FXML
    private TextField emailJugadorTF_PanelSUP; //El TEXTFIELD del email de jugador en el panel Sign up

    @FXML
    private TextField nombreJugadorTF_PanelSIN; //El TEXTFIELD de nombre de jugador en el panel Sign in

    @FXML
    private TextField nombreJugadorTF_PanelSUP; //El TEXTFIELD de nombre de jugador en el panel Sign up

    @FXML
    private TextField passwordJugadorTF_PanelSIN; //El PASSWORDFIELD del panel Sign in

    @FXML
    private TextField passwordJugadorTF_PanelSUP; //El PASSWORDFIELD del panel Sign up

    @FXML
    private Label numeroJugador; //El label del numero de jugador que se cambia para saber que jugador
    public int numereoJugadorActual = 0; //para mostrarlo en la pantalla (en el label numeroJugador) - se sumara en 1

    @FXML
    private Pane panelPrincipal; //El panel que contiene dos buttones (singIn y signUp) que cambian el panel (a partir de cambiar la visibilidad del panel)

    @FXML
    private Pane panelSignIn; //contiene nombreJugadorTF, passwordJugadorTF, signIn button para iniciar la session y signUp button para cambiar la visibilidad del panel

    @FXML
    private Pane panelSignUp; //contiene emailJugador, nombreJugadorTF, passwordJugadorTF, signUp button para registrar y signIn button para cambiar la visibilidad del panel


    @FXML
    public void initialize() {
        //cuando se intializa este clase el numero de jugador se suma en uno y se muestra en su label
        numeroJugador.setText(getNumereoJugadorActual());

        //siempre ver el panel principal al inicio
        panelPrincipal.setVisible(true);
        panelSignIn.setVisible(false);
        panelSignUp.setVisible(false);
    }

    public String getNumereoJugadorActual() {
        //sumar el numero de jugador actual y devolverlo como String
        numereoJugadorActual++;
        return String.valueOf(numereoJugadorActual);
    }

    @FXML
    void VolverInicio(ActionEvent event) throws IOException {
        //volver a la portada de inicio y reset todos los datos
        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void jugadorSiuiente(ActionEvent event) throws IOException {
        //pasar al jugador siguiente o al portada del juego
        //true -> ir a la pagina del siguiente jugador
        //false -> ir a la pagina de juego (RondaView)
        if (CantidadJugadoresController.cantidadJugadores < CantidadJugadoresController.jugadoresPartida.size()) {
            //reset all the textfields
            resetTextFields();

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

    @FXML
    void toPanelSignUp(ActionEvent event) {
        //cambiar la visibilidad al panel Sing Up
        panelPrincipal.setVisible(false);
        panelSignIn.setVisible(false);
        panelSignUp.setVisible(true);
        resetTextFields();
    }

    @FXML
    void toPanelSignIn(ActionEvent event) {
        //cambiar la visibilidad al panel Sign In
        panelSignIn.setVisible(true);
        panelPrincipal.setVisible(false);
        panelSignUp.setVisible(false);
        resetTextFields();
    }

    void resetTextFields() {
        //reset all the TextFields to aviod errors
        emailJugadorTF_PanelSUP.setText("");
        nombreJugadorTF_PanelSUP.setText("");
        passwordJugadorTF_PanelSUP.setText("");
        nombreJugadorTF_PanelSIN.setText("");
        passwordJugadorTF_PanelSIN.setText("");
    }

    @FXML
    public void signInMethod(ActionEvent actionEvent) throws IOException {
        //get the nombreField y passwordField y ver si existe el usuario y la contraseña esta bien hecha sino mostrar el mensaje d error
        //password has to be encrypted before making the query
        //guardar el jugador a la lista de los jugadores de la partida y pasar a la siguiente pagina (que puede ser el proximo jugador o al juego)

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