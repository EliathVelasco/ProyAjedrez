package Piezas;

import java.util.*;
import Partida.*;
public class Caballo extends Pieza {
    public Caballo(ColorPiezas color) {
        super(color,3);
    }

    public ArrayList<int[]> obtenerJugadas(Jugada jugada) {
        ArrayList<int[]> movimientosPosibles = new ArrayList<>();
        movimientosPosibles.add(new int []{jugada.getFilaInicial()+2, jugada.getColumnaInicial()+1});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()+2, jugada.getColumnaInicial()-1});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()+1, jugada.getColumnaInicial()+2});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()+1, jugada.getColumnaInicial()-2});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()-2, jugada.getColumnaInicial()+1});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()-2, jugada.getColumnaInicial()-1});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()-1, jugada.getColumnaInicial()+2});
        movimientosPosibles.add(new int []{jugada.getFilaInicial()-1, jugada.getColumnaInicial()-2});

        return movimientosPosibles;
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);


        //se puede reducir el tamaño haciendo unas comprobaciones pero desde la partida lo para tonces no pasa nada xd
        listaDeMovimientosLegales.addElement(""+(fila+2)+(columna+1));
        listaDeMovimientosLegales.addElement(""+(fila+2)+(columna-1));
        listaDeMovimientosLegales.addElement(""+(fila+1)+(columna+2));
        listaDeMovimientosLegales.addElement(""+(fila+1)+(columna-2));
        listaDeMovimientosLegales.addElement(""+(fila-2)+(columna+1));
        listaDeMovimientosLegales.addElement(""+(fila-2)+(columna-1));
        listaDeMovimientosLegales.addElement(""+(fila-1)+(columna+2));
        listaDeMovimientosLegales.addElement(""+(fila-1)+(columna-2));

        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "C";
    }
}
