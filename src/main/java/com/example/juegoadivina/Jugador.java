package com.example.juegoadivina;

public class Jugador {
    // partidas jugada y ganadas mejor seran como clave primaria de otra tabla (partida)

    //add the id. that is in the DB if it is necesary
    //add email atribute and also to the database
    int ranking;
    String nombre;
    String email;
    String password;
    int partidasJugadas;
    int partidasGanadas;
    int puntos;


    Jugador(int ranking, String nombre, String email, String password) {
        //Constructor de 2 parametros (nombre y password) para registrarse

        // ranking tenemos q darle el mayor (max from sql and add +1 to it)
        this.ranking = ranking;
        this.nombre = nombre;
        this.email = email;
        setPassword(password);
        // iniciar estos datos con 0
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.puntos = 0;
    }

    public Jugador(int ranking, String nombre, String email, String password, int partidasJugadas, int partidasGanadas, int puntos) {
        //constructor para iniciar session - todos los datos se cogen desde el resultado del query
        this.ranking = ranking;
        this.nombre = nombre;
        this.email = email;
        setPassword(password);
        this.partidasJugadas = partidasJugadas;
        this.partidasGanadas = partidasGanadas;
        this.puntos = puntos;
    }


    private void setPassword(String password) {
        this.password = password;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void addPartidaJugada() {
        this.partidasJugadas++;
    }

    public void addPartidaGanadas() {
        this.partidasGanadas++;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }
}
