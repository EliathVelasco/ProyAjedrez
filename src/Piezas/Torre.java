package Piezas;


import java.util.*;

import Movimientos.IMovimientoLateral;
import Partida.*;

public class Torre extends Pieza implements IMovimientoLateral {
    private boolean primerMovimiento;
    public Torre(ColorPiezas color) {
        super(color,5);
        this.primerMovimiento = true;

    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        return obtenerJugadasLegalesLaterales(fila, columna, tablero);
    }


    @Override
    public String toString() {
        return "T";
    }

    @Override
    public void quitarPrimerMovimiento() {
        this.primerMovimiento = false;
    }
    @Override
    public boolean noSeHaMovido() {
        return primerMovimiento;
    }

    @Override
    public Vector obtenerJugadasLegalesLaterales(int filaInicial, int columnaInicial, Tablero tablero) {
        Vector listaDeJugadas = new Vector(1, 1);

        //Movimiento hacia abajo
        for (int i = filaInicial + 1; i < tablero.getCasillas().length; i++) {
            if (!(tablero.getCasillas()[i][columnaInicial].hayPieza())) {
                listaDeJugadas.addElement("" + i + columnaInicial);
            } else if (tablero.getCasillas()[i][columnaInicial].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][columnaInicial].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + columnaInicial);
                break;
            } else {
                break;
            }
        }

        //Movimiento hacia arriba
        for (int i = filaInicial - 1; i>=0; i--) {
            if (!(tablero.getCasillas()[i][columnaInicial].hayPieza())) {
                listaDeJugadas.addElement("" + i + columnaInicial);
            } else if (tablero.getCasillas()[i][columnaInicial].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][columnaInicial].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + columnaInicial);
                break;
            } else {
                break;
            }
        }

        //Movimiento hacia la derecha
        for (int i = columnaInicial+1; i < tablero.getCasillas().length; i++) {
            if (!(tablero.getCasillas()[filaInicial][i].hayPieza())) {
                listaDeJugadas.addElement("" + filaInicial + i);
            } else if (tablero.getCasillas()[filaInicial][i].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[filaInicial][i].getPieza().getColor()) {
                listaDeJugadas.addElement("" + filaInicial + i);
                break;
            } else {
                break;
            }
        }

        //Movimiento hacia la izquierda
        for (int i = columnaInicial-1; i>= 0; i--) {
            if (!(tablero.getCasillas()[filaInicial][i].hayPieza())) {
                listaDeJugadas.addElement("" + filaInicial + i);
            } else if (tablero.getCasillas()[filaInicial][i].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[filaInicial][i].getPieza().getColor()) {
                listaDeJugadas.addElement("" + filaInicial + i);
                break;
            } else {
                break;
            }
        }
        return listaDeJugadas;
    }
}
