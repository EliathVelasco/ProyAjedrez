package Piezas;

import java.util.*;
import Partida.*;

public class Rey extends Pieza {
    public Rey(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        this.listaDeMovimientosLegales.removeAllElements();
        this.listaDeMovimientosLegales.addElement("" +(columna)+(fila+1));
        this.listaDeMovimientosLegales.addElement("" +(columna+1)+(fila+1));
        this.listaDeMovimientosLegales.addElement("" +(columna-1)+(fila+1));
        this.listaDeMovimientosLegales.addElement("" +(columna)+(fila-1));
        this.listaDeMovimientosLegales.addElement("" +(columna+1)+(fila-1));
        this.listaDeMovimientosLegales.addElement("" +(columna-1)+(fila-1));
        this.listaDeMovimientosLegales.addElement("" +(columna+1)+(fila));
        this.listaDeMovimientosLegales.addElement("" +(columna-1)+(fila));
        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "R";
    }
}
