package Piezas;

import java.util.*;
import Partida.*;
public class Caballo extends Pieza {
    public Caballo(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        this.listaDeMovimientosLegales.removeAllElements();
        listaDeMovimientosLegales.addElement(""+(columna+1)+(fila+2));
        listaDeMovimientosLegales.addElement(""+(columna-1)+(fila+2));
        listaDeMovimientosLegales.addElement(""+(columna+1)+(fila-2));
        listaDeMovimientosLegales.addElement(""+(columna-1)+(fila-2));
        listaDeMovimientosLegales.addElement(""+(columna+2)+(fila+1));
        listaDeMovimientosLegales.addElement(""+(columna+2)+(fila-1));
        listaDeMovimientosLegales.addElement(""+(columna-2)+(fila+1));
        listaDeMovimientosLegales.addElement(""+(columna-2)+(fila-1));
        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "C";
    }
}
