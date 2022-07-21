package Piezas;

import java.util.*;
import Movimientos.IMovimientoDiagonal;
import Movimientos.IMovimientoLateral;
import Partida.*;
public class Dama extends Pieza implements IMovimientoLateral, IMovimientoDiagonal{
    public Dama(ColorPiezas color) {
        super(color,9);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);

        listaDeMovimientosLegales.addAll(obtenerJugadasLegalesDiagonales(fila, columna, tablero));
        listaDeMovimientosLegales.addAll(obtenerJugadasLegalesLaterales(fila, columna, tablero));

        return listaDeMovimientosLegales;
    }

    @Override
    public String toString() {
        return "D";
    }

    @Override
    public Vector obtenerJugadasLegalesDiagonales(int filaInicial, int columnaInicial, Tablero tablero) {
        Vector listaDeJugadas = new Vector(1,1);

        int auxColumna1 = columnaInicial+1;


        //Movimiento derecha hacia abajo
        for (int i = filaInicial+1; i < 8; i++){
            if (!(tablero.getCasillas()[i][auxColumna1].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna1);
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna1].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna1);
                break;
            } else {
                break;
            }
            if (auxColumna1 < 7){
                auxColumna1++;
            } else {
                break;
            }

        }

        //Movimiento derecha hacia arriba
        auxColumna1 = columnaInicial + 1;
        for (int i = filaInicial -1; i>=0; i--){
            if (!(tablero.getCasillas()[i][auxColumna1].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna1);
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna1].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna1);
                break;
            } else {
                break;
            }
            if (auxColumna1 < 7){
                auxColumna1++;
            } else {
                break;
            }
        }


        int auxColumna2 = columnaInicial - 1 ;
        for (int i = filaInicial+1; i < 8; i++){
            if (!(tablero.getCasillas()[i][auxColumna2].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna2);
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[i][auxColumna2].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna2);
                break;
            } else {
                break;
            }
            if (auxColumna2 > 0){
                auxColumna2--;
            } else {
                break;
            }
        }


        auxColumna2 = columnaInicial-1;
        for (int i = filaInicial-1; i>=0; i--){
            if (!(tablero.getCasillas()[i][auxColumna2].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna2);
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna2].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna2);
                break;
            } else {
                break;
            }
            if (auxColumna2 > 0){
                auxColumna2--;
            } else {
                break;
            }
        }
        return listaDeJugadas;
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
