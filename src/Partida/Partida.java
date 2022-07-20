package Partida;

import Errores.*;

import java.util.Scanner;

import static Partida.ColorPiezas.BLANCAS;
import static Partida.ColorPiezas.NEGRAS;

public class Partida {
    private Jugador jugadorDeBlancas;
    private Jugador jugadorDeNegras;
    protected Tablero tablero;
    private ColorPiezas turnoActual;

    public Partida() {
        this.jugadorDeBlancas = new Jugador(BLANCAS);
        this.jugadorDeNegras = new Jugador(NEGRAS);
        this.tablero = new Tablero();
        this.turnoActual = BLANCAS;
    }

    public void preguntarJugada() {
        tablero.imprimirTablero();
        Scanner scannerDelBlanco = new Scanner(System.in);
        Scanner scannerDelNegro = new Scanner(System.in);

        for (; ; ) {
            while (turnoActual == BLANCAS) {
                try {
                    String jugadaDelBlanco = scannerDelBlanco.next();
                    jugadorDeBlancas.ingresarJugada(jugadaDelBlanco, tablero);
                    tablero.imprimirTablero();
                    setTurnoActual(NEGRAS);
                } catch (PiezaNoCorrespondiente | CoordenadasInválidas e) {
                    System.out.println(e.getMessage());
                }
            }

            while (turnoActual == NEGRAS) {
                try {
                    String jugadaDelNegro = scannerDelNegro.next();
                    jugadorDeNegras.ingresarJugada(jugadaDelNegro, tablero);
                    tablero.imprimirTablero();
                    setTurnoActual(ColorPiezas.BLANCAS);
                } catch (PiezaNoCorrespondiente | CoordenadasInválidas e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    public Jugador getJugadorDeBlancas() {
        return jugadorDeBlancas;

    }

    public Jugador getJugadorDeNegras() {
        return jugadorDeNegras;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public ColorPiezas getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(ColorPiezas siguienteTurno) {
        this.turnoActual = siguienteTurno;
    }
}
