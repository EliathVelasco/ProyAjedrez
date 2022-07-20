package Piezas;

import java.util.*;

import Partida.*;

public class Peon extends Pieza {
    private boolean primerMovimiento;

    public Peon(ColorPiezas color) {
        super(color);
        this.primerMovimiento = true;
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int filas, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1, 1);
        if (color == ColorPiezas.NEGRAS) {
            agregarMovimientosPiezasNegras(filas, columna, listaDeMovimientosLegales);
            agregarMovimientosDeCapturaBlanca(filas, columna, tablero, listaDeMovimientosLegales);
        } else {
            agregarMovimientosPiezasBlancas(filas, columna, listaDeMovimientosLegales);
            agregarMovimientosDeCapturaNegra(filas, columna, tablero, listaDeMovimientosLegales);
        }
        return listaDeMovimientosLegales;
    }

    private void agregarMovimientosDeCapturaNegra(int filas, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {

        if (columna > 0 && filas < 8 && tablero.getCasillas()[filas + 1][columna - 1].hayPieza()) {
            listaDeMovimientosLegales.addElement("" + (filas + 1) + (columna - 1));

        } else if (columna < 8 && filas < 8 && tablero.getCasillas()[filas + 1][columna + 1].hayPieza()) {
            listaDeMovimientosLegales.addElement("" + (filas + 1) + (columna + 1));
        }

    }


    private void agregarMovimientosPiezasBlancas(int filas, int columna, Vector listaDeMovimientosLegales) {
        if (primerMovimiento) {
            for (int i = filas + 1; i < filas + 3; i++) {
                listaDeMovimientosLegales.addElement("" + i + columna);
            }
        } else {
            listaDeMovimientosLegales.add("" + (filas + 1) + columna);
        }
    }

    private void agregarMovimientosPiezasNegras(int filas, int columna, Vector listaDeMovimientosLegales) {
        if (primerMovimiento) {
            for (int i = filas - 1; i > filas - 3; i--) {
                listaDeMovimientosLegales.addElement("" + i + columna);
            }
        } else {
            listaDeMovimientosLegales.addElement("" + (filas - 1) + columna);
        }
    }

    private void agregarMovimientosDeCapturaBlanca(int filas, int columna, Tablero tablero, Vector listaDeMovimientosLegales) {

        if (filas > 0 && columna > 0 && tablero.getCasillas()[filas - 1][columna - 1].hayPieza()) {
            listaDeMovimientosLegales.addElement("" + (filas - 1) + (columna - 1));
        } else if (filas > 0 && columna < 8 && tablero.getCasillas()[filas - 1][columna + 1].hayPieza()) {
            listaDeMovimientosLegales.addElement("" + (filas - 1) + (columna + 1));
        }

    }

    public void quitarPrimerMovimiento() {
        this.primerMovimiento = false;
    }

    @Override
    public String toString() {
        return "P";
    }
}
