package Piezas;

import java.util.*;

import Partida.*;

public class Rey extends Pieza {
    private boolean primerMovimiento;

    public Rey(ColorPiezas color) {
        super(color, 0);
        primerMovimiento = true;
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1, 1);

        //huevada mal hecha

        if (fila < 7) {
            if (!(tablero.getCasillas()[fila + 1][columna].hayPieza())) {
                listaDeMovimientosLegales.addElement("" + (fila + 1) + columna);
            } else if (tablero.getCasillas()[fila + 1][columna].getPieza().getColor() != color) {
                listaDeMovimientosLegales.addElement("" + (fila + 1) + columna);
            }

            if (columna < 7) {
                if (!(tablero.getCasillas()[fila + 1][columna + 1].hayPieza())) {
                    listaDeMovimientosLegales.addElement("" + (fila + 1) + (columna + 1));
                } else if (tablero.getCasillas()[fila + 1][columna + 1].getPieza().getColor() != color) {
                    listaDeMovimientosLegales.addElement("" + (fila + 1) + (columna + 1));
                }
            }

            if (columna > 0) {
                if (!(tablero.getCasillas()[fila + 1][columna - 1].hayPieza())) {
                    listaDeMovimientosLegales.addElement("" + (fila + 1) + (columna - 1));
                } else if (tablero.getCasillas()[fila + 1][columna - 1].getPieza().getColor() != color) {
                    listaDeMovimientosLegales.addElement("" + (fila + 1) + (columna - 1));
                }
            }
        }

        if (fila > 0) {
            if (fila < 7) {
                if (!(tablero.getCasillas()[fila - 1][columna].hayPieza())) {
                    listaDeMovimientosLegales.addElement("" + (fila - 1) + columna);
                } else if (tablero.getCasillas()[fila - 1][columna].getPieza().getColor() != color) {
                    listaDeMovimientosLegales.addElement("" + (fila - 1) + columna);
                }

                if (columna < 7) {
                    if (!(tablero.getCasillas()[fila - 1][columna + 1].hayPieza())) {
                        listaDeMovimientosLegales.addElement("" + (fila - 1) + (columna + 1));
                    } else if (tablero.getCasillas()[fila - 1][columna + 1].getPieza().getColor() != color) {
                        listaDeMovimientosLegales.addElement("" + (fila - 1) + (columna + 1));
                    }
                }

                if (columna > 0) {
                    if (!(tablero.getCasillas()[fila - 1][columna - 1].hayPieza())) {
                        listaDeMovimientosLegales.addElement("" + (fila - 1) + (columna - 1));
                    } else if (tablero.getCasillas()[fila - 1][columna - 1].getPieza().getColor() != color) {
                        listaDeMovimientosLegales.addElement("" + (fila - 1) + (columna - 1));
                    }
                }
            }
        }

        if (columna < 7){
            listaDeMovimientosLegales.addElement(""+fila+(columna+1));
        }
        if (columna > 0){
            listaDeMovimientosLegales.addElement(""+fila+(columna-1));
        }

        if (primerMovimiento){
            if (!(tablero.getCasillas()[fila][columna+1].hayPieza()) && !(tablero.getCasillas()[fila][columna+2].hayPieza()) && tablero.getCasillas()[fila][columna+3].hayPieza()
            && tablero.getCasillas()[fila][columna+3].getPieza().noSeHaMovido()){
                listaDeMovimientosLegales.addElement(""+fila+(columna+2));
            }
            if (!(tablero.getCasillas()[fila][columna-1].hayPieza()) && !(tablero.getCasillas()[fila][columna-2].hayPieza())&& !(tablero.getCasillas()[fila][columna-3].hayPieza()) && tablero.getCasillas()[fila][columna-4].hayPieza()
                    && tablero.getCasillas()[fila][columna-4].getPieza().noSeHaMovido()){
                listaDeMovimientosLegales.addElement(""+fila+(columna-2));
            }
        }

        return listaDeMovimientosLegales;
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
