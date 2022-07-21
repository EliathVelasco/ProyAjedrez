package Piezas;

import java.util.*;
import Partida.*;

public class Rey extends Pieza {
    private boolean primerMovimiento;
    public Rey(ColorPiezas color) {
        super(color,0);
        primerMovimiento = true;
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);

        //huevada mal hecha

        if (fila>=0 && fila <=7 && columna >=0 && columna <=7){

        }

        obtenerJugadaDecendente(fila+1, columna, tablero, listaDeMovimientosLegales);
        obtenerJugadaDecendente(fila+1, columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaDecendente(fila+1, columna-1, tablero, listaDeMovimientosLegales);

        obtenerJugadaAscendente(fila-1,columna, tablero, listaDeMovimientosLegales);
        obtenerJugadaAscendente(fila-1,columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaAscendente(fila-1,columna-1, tablero, listaDeMovimientosLegales);

        obtenerJugadaDerecha(fila, columna+1, tablero, listaDeMovimientosLegales);
        obtenerJugadaIzquierda(fila, columna-1, tablero, listaDeMovimientosLegales);

        if (primerMovimiento){
            if (tablero.getCasillas()[fila][columna+3].getPieza().noSeHaMovido()){
                listaDeMovimientosLegales.addElement(""+fila+(columna+3));
            }
            if (tablero.getCasillas()[fila][columna-4].getPieza().noSeHaMovido()){
                listaDeMovimientosLegales.addElement(""+fila+(columna-4));
            }
        }

        return listaDeMovimientosLegales;
    }

    private void obtenerJugadaDecendente(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila <=7 && columna <=7) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila-1][columna].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }

    private void obtenerJugadaAscendente(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila <=7 && columna <=7) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila+1][columna].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }
    private void obtenerJugadaDerecha(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila <=7 && columna <=7) {
            if (!(tablero.getCasillas()[fila][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            } else if (tablero.getCasillas()[fila][columna].hayPieza() && tablero.getCasillas()[fila][columna].getPieza().getColor() != tablero.getCasillas()[fila][columna - 1].getPieza().getColor()) {
                listaDeMovimientosLegales.addElement("" + (fila) + columna);
            }
        }
    }

    private void obtenerJugadaIzquierda(int fila, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {
        if (fila>=0 && columna>=0 && fila <=7 && columna <=7) {
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

    @Override
    public void quitarPrimerMovimiento() {
        primerMovimiento = false;
    }
}
