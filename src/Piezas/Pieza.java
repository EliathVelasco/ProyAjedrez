package Piezas;

import java.util.*;

import Partida.*;

public abstract class Pieza {
    private int valorDePieza;
    protected ColorPiezas color;

    public Pieza(ColorPiezas color, int valorDePieza) {
        this.valorDePieza = valorDePieza;
        this.color = color;
    }

    public abstract Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero);


    public ColorPiezas getColor() {
        return color;
    }

    public void quitarPrimerMovimiento() {

    }
}
