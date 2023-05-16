package com.example.juegoadivina;

import java.util.ArrayList;

public class JugadorPartida extends Jugador{
    //add an attribute calledthe ranking Partida or Posicion para mostrarla en el resultadoPartida, que se actualiza a partir de cantidad de rondas que ha jugado el jugador -> mas rondas , good ranking
    public int vidas;
    public boolean masCercano = false;
    public ArrayList<Integer> numerosElegidos = new ArrayList<>();

    public JugadorPartida(Jugador jugador) {
        super(jugador.getRanking(), jugador.getNombre(), jugador.getEmail(), jugador.getPassword(), jugador.getPartidasJugadas(), jugador.getPartidasGanadas(), jugador.getPuntos());
        this.vidas = 5;
    }
//    public JugadorPartida(int ranking, String nombre, String email, String password) throws Exception {
//        super(ranking, nombre, email, password);
//    }

    public JugadorPartida(int ranking, String nombre, String email, String password, int partidasJugadas, int partidasGanadas, int puntos) {
        super(ranking, nombre, email, password, partidasJugadas, partidasGanadas, puntos);
        vidas = 5;
    }

    public int getVidas() {
        return vidas;
    }

    public boolean esVivo() {
        return vidas > 0;
    }

    public ArrayList<Integer> getNumerosElegidos() {
        return numerosElegidos;
    }

    public int getNumeroElegido() {
        //get el ultimo numero Elegido
        return numerosElegidos.get(numerosElegidos.size()-1);
    }

    public void quitarVida() {
        if (vidas > 0) this.vidas--;
    }

    public int cantidadRondas() {
        return this.numerosElegidos.size();
    }


}
