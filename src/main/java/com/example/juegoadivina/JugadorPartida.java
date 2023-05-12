package com.example.juegoadivina;

import java.util.ArrayList;

public class JugadorPartida extends Jugador{
    //se puede no ser hija de Jugador
    //tendra un id, vidas y vivo(true o false)
//    public int id;
    public int vidas;
    public ArrayList<Integer> numerosElejidos = new ArrayList<>();

    public JugadorPartida(Jugador jugador) throws Exception {
        super(jugador.getRanking(), jugador.getNombre(), jugador.getEmail(), jugador.getPassword(), jugador.getPartidasJugadas(), jugador.getPartidasGanadas(), jugador.getPuntos());
        this.vidas = 5;
    }
//    public JugadorPartida(int ranking, String nombre, String email, String password) throws Exception {
//        super(ranking, nombre, email, password);
//    }

    public JugadorPartida(int ranking, String nombre, String email, String password, int partidasJugadas, int partidasGanadas, int puntos) throws Exception {
        super(ranking, nombre, email, password, partidasJugadas, partidasGanadas, puntos);
        vidas = 5;
    }

    public int getVidas() {
        return vidas;
    }

    public boolean esVivo() {
        return vidas > 0;
    }

    public ArrayList<Integer> getNumerosElejidos() {
        return numerosElejidos;
    }

    public int getNumeroElejedo(int i) {
        return numerosElejidos.get(i);
    }


}
