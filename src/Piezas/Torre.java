package Piezas;


import java.util.*;

import Movimientos.IMovimientoLateral;
import Partida.*;

public class Torre extends Pieza implements IMovimientoLateral {
    public Torre(ColorPiezas color) {
        super(color);

    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        this.listaDeMovimientosLegales.removeAllElements();



        this.listaDeMovimientosLegales = IMovimientoLateral.obtenerJugadasLegales(fila,columna,tablero);

        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "T";
    }
}
