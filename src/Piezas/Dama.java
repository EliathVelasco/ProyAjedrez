package Piezas;

import java.util.*;
import Movimientos.IMovimientoDiagonal;
import Movimientos.IMovimientoLateral;
import Partida.*;
public class Dama extends Pieza implements IMovimientoLateral, IMovimientoDiagonal{
    public Dama(ColorPiezas color) {
        super(color,9);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);

        listaDeMovimientosLegales.addAll(IMovimientoDiagonal.obtenerJugadasLegales(fila,columna,tablero));
        listaDeMovimientosLegales.addAll(IMovimientoLateral.obtenerJugadasLegales(fila,columna,tablero));

        return listaDeMovimientosLegales;
    }

    @Override
    public String toString() {
        return "D";
    }
}
