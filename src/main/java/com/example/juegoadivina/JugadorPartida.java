package com.example.juegoadivina;

public class JugadorPartida extends Jugador{
    //se puede no ser hija de Jugador
    //tendra un id, vidas y vivo(true o false)
    public static int id = 0;
    public int vidas;
    public boolean vivo;

    JugadorPartida(String nombre, String password) throws Exception {
        super(nombre, password);
        id++;
        vidas = 5;
        vivo = true;
    }

    public JugadorPartida(int ranking, String nombre, String password, int partidasJugadas, int partidasGanadas, int puntos) throws Exception {
        super(ranking, nombre, password, partidasJugadas, partidasGanadas, puntos);
        id++;
        vidas = 5;
        vivo = true;
    }
}
