package Piezas;

import java.util.*;

import Partida.*;

public abstract class Pieza {
    protected ColorPiezas color;

    public Pieza(ColorPiezas color) {
        this.color = color;
    }

    public abstract Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero);


    public ColorPiezas getColor() {
        return color;
    }

}
