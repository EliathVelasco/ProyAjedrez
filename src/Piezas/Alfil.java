package Piezas;

import java.util.*;

import Movimientos.IMovimientoDiagonal;
import Partida.*;

public class Alfil extends Pieza implements IMovimientoDiagonal{
    public Alfil(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        return IMovimientoDiagonal.obtenerJugadasLegales(fila,columna,tablero);
    }


    @Override
    public String toString() {
        return "A";
    }
}