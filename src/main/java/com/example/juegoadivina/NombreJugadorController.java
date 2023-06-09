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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class NombreJugadorController {
    //despues de tener la cantidad, crear una lista de jugadores cada uno con su nombre
    //en jugador X : X empieza desde 1 hasta cantidad (i <= cantidad)


    /* add the control : (fields are filled with correct value)
     * check the username and password with the database
     *   if the user exists
     *       check if the password is good (password is encrypted)
     *   if the user doesn't exist
     *       create a jugador from this username and its password
     *
     *   */

    private Stage stage;
    private Scene scene;
    MongoCon mongoCon;
    public static ArrayList<Jugador> jugadores = new ArrayList<>(); //donde se guardan los jugadores
    public static ArrayList<JugadorPartida> jugadoresPartida = new ArrayList<>(); //donde se guardan los jugadores de la partida

    @FXML
    public Label errorLabel;

    @FXML
    private TextField emailJugadorTF_PanelSUP; //El TEXTFIELD del email de jugador en el panel Sign up

    @FXML
    private TextField nombreJugadorTF_PanelSIN; //El TEXTFIELD de nombre de jugador en el panel Sign in

    @FXML
    private TextField nombreJugadorTF_PanelSUP; //El TEXTFIELD de nombre de jugador en el panel Sign up

    @FXML
    private PasswordField passwordJugadorTF_PanelSIN; //El PASSWORDFIELD del panel Sign in

    @FXML
    private PasswordField passwordJugadorTF_PanelSUP; //El PASSWORDFIELD del panel Sign up

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

        mongoCon = new MongoCon();

    }

    public String getNumereoJugadorActual() {
        //sumar el numero de jugador actual y devolverlo como String
        numereoJugadorActual++;
        return String.valueOf(numereoJugadorActual);
    }

    @FXML
    void VolverInicio(ActionEvent event) throws IOException {
        //volver a la portada de inicio y reset todos los datos

        //reset the value of the arralist of Jugadores and JugadoresPartida
        jugadores = null;
        jugadoresPartida = null;

        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void jugadorSiguiente(ActionEvent event) throws Exception {
        //pasar al jugador siguiente o al portada del juego
        //true -> ir a la pagina del siguiente jugador
        //false -> ir a la pagina de juego (RondaView)
        if (jugadores.size() < CantidadJugadoresController.cantidadJugadores) {
            //reset all the textfields
            resetTextFields();

            //sumar el numero de jugador actual
            numeroJugador.setText(getNumereoJugadorActual());

        } else {
            //cuando estamos en la pagina del ultimo jugador -> pasar al juego
            fillJugadoresPartida();

            //close la conexion
            mongoCon.close();

            //Crear la lista de JugadoresPartida
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
    public void signInMethod(ActionEvent actionEvent) throws Exception {
        //get the nombreField y passwordField y ver si existe el usuario y la contraseña esta bien hecha sino mostrar el mensaje d error
        //password has to be encrypted before making the query
        //guardar el jugador a la lista de los jugadores de la partida y pasar a la siguiente pagina (que puede ser el proximo jugador o al juego)

        String nombre = nombreJugadorTF_PanelSIN.getText();
        String password = PasswordEncrypter.encryptPassword(passwordJugadorTF_PanelSIN.getText()); // get the password that the user writed encrypted

        //make sure the fields are not empty
        if ((!nombre.isEmpty()) && (!password.isEmpty())) {

            if (mongoCon.isUserPassValid(nombre, password) != null) {
                // get all the info of this user from the query's result and save it to arraylist jugadoresPartida
                Jugador jugador = mongoCon.isUserPassValid(nombre, password);
                /*en nombreJugador en vez de crear JugadorPartida a la vez con Jugador -> crear una lista de Jugador primero y despues de tenerla hecha creamos una lista de JugadorPartida a partir de la primera lista*/

                //añadir este jugador a la lista de los jugadores
                jugadores.add(jugador);

                //pasar a la otra pagina : mejor que se hace a partir de llamar a un metodo que lo hace

                //comments to delete
//                    System.out.println("CantidadJugadoresController.cantidadJugadores: " + CantidadJugadoresController.cantidadJugadores);
//                    System.out.println("CantidadJugadoresController.jugadoresPartida.size()" + jugadores.size());

                jugadorSiguiente(actionEvent);

            } else {
                //error message -- labelError.setText("wrong name or password")
                System.out.println("labelError.setText('wrong name or password')");
                errorLabel.setText("wrong name or password");
            }
        } else {
            //error message -- labelError.setText("empty fields")
            System.out.println("labelError.setText('empty fields')");
            errorLabel.setText("empty fields");
        }
    }

    @FXML
    public void signUpMethod(ActionEvent actionEvent) throws Exception {
        //get the fields, ver si el nombreJugador no existe , insert el jugador en la base de datos y tambien en la partida

        String nombre = nombreJugadorTF_PanelSUP.getText();
        String email = emailJugadorTF_PanelSUP.getText();
        String password = passwordJugadorTF_PanelSUP.getText();

        //make sure the fields are not empty
        if ((!nombre.isEmpty()) && (!email.isEmpty()) && (!password.isEmpty())) {
            //make sure there is no user with this nombre or email
            if (mongoCon.isNombreEmailAvailable(nombre, email) ) {
                //crear objeto de este jugador
                Jugador jugador = new Jugador(mongoCon.getLatestRank() + 1, nombre, email, PasswordEncrypter.encryptPassword(password)); //darle el ultimo rank+1

                //llamar a un metodo para insertar el jugador a la base datos
                MongoCon.signUp(jugador);

                //añadir este jugador a la lista de los jugadores
                jugadores.add(jugador);

                //comments to delete
//                    System.out.println("signUpMethod -> mongoCon.isNombreEmailAvailable(nombre, email) : true");
//                    System.out.println("\tpasswordJugadorTF_PanelSUP.getText(): " + passwordJugadorTF_PanelSUP.getText() + " ---- " + password);
//                    System.out.println("\tpasswordJugadorTF_PanelSUP.getText(): ENCRYPTED : " + PasswordEncrypter.encryptPassword(password));
//                    System.out.println("\tCantidadJugadoresController.cantidadJugadores: " + CantidadJugadoresController.cantidadJugadores);
//                    System.out.println("\tCantidadJugadoresController.jugadores.size(): " + jugadores.size());


                //pasar a la otra pagina : mejor que se hace a partir de llamar a un metodo que lo hace
                jugadorSiguiente(actionEvent);
            } else {
                //error message -- labelError.setText("usuario existe")
                System.out.println("labelError.setText('usuario existe')");
                errorLabel.setText("usuario existe");

            }
        } else {
            //error message -- labelError.setText("empty fields")
            System.out.println("labelError.setText('empty fields')");
            errorLabel.setText("empty fields");
        }
    }

    static void fillJugadoresPartida() throws Exception {
        //method to fill the JugadoresPartida a partir de la lista Jugadores
        //it is called just before passing to the game (rondaView)
        for (int i = 0; i < jugadores.size(); i++) {
            //crear JugadorPartida a partir de el objeto Jugador
            JugadorPartida jugadorPartida = new JugadorPartida(jugadores.get(i));
            jugadoresPartida.add(jugadorPartida);
        }
    }
}