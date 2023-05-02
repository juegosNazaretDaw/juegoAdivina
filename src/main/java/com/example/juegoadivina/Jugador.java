package com.example.juegoadivina;

public class Jugador {
    // la contraseña tiene que se guarda encrypted
    // partidas jugada y ganadas mejor seran como clave primaria de otra tabla (partida)
    int ranking;
    String nombre;
    String password;
    // contraseña no seria necesaria
    int partidasJugadas;
    int partidasGanadas;
    int puntos;

    Jugador(String nombre, String password) throws Exception {
        //Constructor de 2 parametros (nombre y password) para registrarse

        // ranking tenemos q darle el mayor (max from sql and add +1 to it)
        this.nombre = nombre;
        setPassword(password);
        // iniciar estos datos con 0
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.puntos = 0;
    }

    public Jugador(int ranking, String nombre, String password, int partidasJugadas, int partidasGanadas, int puntos) throws Exception {
        //constructor para iniciar session - todos los datos se cogen desde el resultado del query
        this.ranking = ranking;
        this.nombre = nombre;
        setPassword(password);
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.puntos = puntos;
    }


    private void setPassword(String password) throws Exception {
        if (password.isEmpty()) {
            //throw an error if la contraseña is empty
            throw new Exception("cantraseña vacia");
        }
        //guardar la contraseña encryptada
        this.password = PasswordEncrypter.encryptPassword(password);
    }


}
