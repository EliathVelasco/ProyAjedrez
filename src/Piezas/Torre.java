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

    public ArrayList<ArrayList<int[]>> obtenerJugadas(Jugada jugada) {
        ArrayList<ArrayList<int[]>> movimientosPosibles = new ArrayList<>();
        ArrayList<int[]> aux = new ArrayList<>();

        //Movimientos hacia abajo
        for (int i = jugada.getFilaInicial(); i<8;i++){
            aux.add(new int[]{i, jugada.getColumnaInicial()});
        }

        limpiarYAñadir(movimientosPosibles, aux);

        //Movimientos hacia arriba
        for (int i = jugada.getFilaInicial(); i>=0; i--){
            aux.add(new int[]{i, jugada.getColumnaInicial()});
        }

        limpiarYAñadir(movimientosPosibles, aux);

        //Movimientos hacia la izquierda
        for (int i = jugada.getColumnaInicial(); i>=0; i--){
            aux.add(new int[]{jugada.getFilaInicial(), i});
        }

        limpiarYAñadir(movimientosPosibles, aux);

        //Movimientos hacia la derecha
        for (int i = jugada.getColumnaInicial(); i <8; i++){
            aux.add(new int[]{jugada.getFilaInicial(), i});
        }

        limpiarYAñadir(movimientosPosibles, aux);

        return movimientosPosibles;
    }

    private void limpiarYAñadir(ArrayList<ArrayList<int[]>> movimientosPosibles, ArrayList<int[]> aux) {
        movimientosPosibles.add((ArrayList<int[]>) aux.clone());
        aux.clear();
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
