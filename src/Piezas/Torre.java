package Piezas;


import java.util.*;

import Movimientos.IMovimientoLateral;
import Partida.*;

public class Torre extends Pieza implements IMovimientoLateral {
    public Torre(ColorPiezas color) {
        super(color,5);

    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        return IMovimientoLateral.obtenerJugadasLegales(fila,columna,tablero);
    }


    @Override
    public String toString() {
        return "T";
    }
}
