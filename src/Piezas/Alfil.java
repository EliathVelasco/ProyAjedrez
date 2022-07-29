package Piezas;

import java.util.*;

import Movimientos.IMovimientoDiagonal;
import Partida.*;

public class Alfil extends Pieza implements IMovimientoDiagonal{
    public Alfil(ColorPiezas color) {
        super(color, 3);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        return obtenerJugadasLegalesDiagonales(fila, columna, tablero);
    }


    @Override
    public String toString() {
        return "A";
    }

    public ArrayList<ArrayList<int[]>> obtenerJugadas(Jugada jugada){
        int [] auxCoordenadas = new int [2];
        ArrayList<ArrayList<int []>> movimientosPosibles = new ArrayList<>();
        ArrayList<int []> aux = new ArrayList<>();

        int auxColumna = jugada.getColumnaInicial();

        for (int i = jugada.getFilaInicial(); i < 8; i++){
            auxCoordenadas[0] = i;
            auxCoordenadas[1] = auxColumna;
            aux.add(auxCoordenadas);

            if (auxColumna < 7){
                auxColumna++;
            }else {
                break;
            }
        }

        movimientosPosibles.add(aux);
        aux.clear();

        auxColumna = jugada.getColumnaInicial();

        for (int i = jugada.getFilaInicial(); i < 8; i++){

            auxCoordenadas[0] = i;
            auxCoordenadas[1] = auxColumna;
            aux.add(auxCoordenadas);

            if (auxColumna > 0){
                auxColumna--;
            }else {
                break;
            }
        }

        movimientosPosibles.add(aux);
        aux.clear();

        auxColumna = jugada.getColumnaInicial();

        for (int i = jugada.getFilaInicial(); i >= 0; i--){
            auxCoordenadas[0] = i;
            auxCoordenadas[1] = auxColumna;
            aux.add(auxCoordenadas);
            if (auxColumna < 7){
                auxColumna++;
            }else {
                break;
            }
        }
        movimientosPosibles.add(aux);
        aux.clear();

        auxColumna = jugada.getColumnaInicial();

        for (int i = jugada.getFilaInicial(); i >= 0; i--){
            auxCoordenadas[0] = i;
            auxCoordenadas[1] = auxColumna;
            aux.add(auxCoordenadas);
            if (auxColumna > 0){
                auxColumna--;
            }else {
                break;
            }
        }

        movimientosPosibles.add(aux);
        aux.clear();

        return movimientosPosibles;
    }

    @Override
    public Vector obtenerJugadasLegalesDiagonales(int filaInicial, int columnaInicial, Tablero tablero) {
        Vector listaDeJugadas = new Vector(1,1);

        int auxColumna1 = columnaInicial+1;


        //Movimiento derecha hacia abajo
        for (int i = filaInicial+1; i < 8; i++){
            if (!(tablero.getCasillas()[i][auxColumna1].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna1);
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
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
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
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
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
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
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[filaInicial][columnaInicial].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
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
}