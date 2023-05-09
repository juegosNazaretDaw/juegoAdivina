package com.example.juegoadivina;

public class JugadorPartida extends Jugador{
    //se puede no ser hija de Jugador
    //tendra un id, vidas y vivo(true o false)
    public int id ;
    public int vidas;

    public JugadorPartida(Jugador jugador) throws Exception {
        super(jugador.getRanking(), jugador.getNombre(), jugador.getEmail(), jugador.getPassword(), jugador.getPartidasJugadas(), jugador.getPartidasGanadas(), jugador.getPuntos());
    }
//    public JugadorPartida(int ranking, String nombre, String email, String password) throws Exception {
//        super(ranking, nombre, email, password);
//    }

    public JugadorPartida(int ranking, String nombre, String email, String password, int partidasJugadas, int partidasGanadas, int puntos) throws Exception {
        super(ranking, nombre, email, password, partidasJugadas, partidasGanadas, puntos);
    }

    public int getVidas() {
        return vidas;
    }

    public boolean esVivo() {
        return vidas > 0;
    }
}
