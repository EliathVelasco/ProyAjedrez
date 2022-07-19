package Piezas;

import java.util.*;
import Partida.*;

public class Rey extends Pieza {
    public Rey(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);

        listaDeMovimientosLegales.addElement("" +(columna)+(fila+1));
        listaDeMovimientosLegales.addElement("" +(columna+1)+(fila+1));
        listaDeMovimientosLegales.addElement("" +(columna-1)+(fila+1));
        listaDeMovimientosLegales.addElement("" +(columna)+(fila-1));
        listaDeMovimientosLegales.addElement("" +(columna+1)+(fila-1));
        listaDeMovimientosLegales.addElement("" +(columna-1)+(fila-1));
        listaDeMovimientosLegales.addElement("" +(columna+1)+(fila));
        listaDeMovimientosLegales.addElement("" +(columna-1)+(fila));

        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "R";
    }
}
