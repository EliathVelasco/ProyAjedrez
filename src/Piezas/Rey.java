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

        obtenerJugadaDecendente(fila+1, columna, tablero, listaDeMovimientosLegales);
        obtenerJugadaDecendente(fila+1, columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaDecendente(fila+1, columna-1, tablero, listaDeMovimientosLegales);

        obtenerJugadaAscendente(fila-1,columna, tablero, listaDeMovimientosLegales);
        obtenerJugadaAscendente(fila-1,columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaAscendente(fila-1,columna-1, tablero, listaDeMovimientosLegales);

        obtenerJugadaDerecha(fila, columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaIzquierda(fila, columna-1, tablero, listaDeMovimientosLegales);

        return listaDeMovimientosLegales;
    }

    private void obtenerJugadaDecendente(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila < 8 && columna <8) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila-1][columna].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }

    private void obtenerJugadaAscendente(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila < 8 && columna <8) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila+1][columna].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }
    private void obtenerJugadaDerecha(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila < 8 && columna <8) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila][columna - 1].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }

    private void obtenerJugadaIzquierda(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila < 8 && columna <8) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila][columna + 1].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }


    @Override
    public String toString() {
        return "R";
    }
}
