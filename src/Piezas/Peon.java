package Piezas;

import java.util.*;
import Partida.*;

public class Peon extends Pieza {
    public Peon(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int filas, int columna, Tablero tablero) {
        Vector listaDeMovimientosLegales = new Vector(1,1);
        listaDeMovimientosLegales.removeAllElements();
        if (color == ColorPiezas.NEGRAS){
            for (int i = filas-1; i>filas-3 ;i--){
                listaDeMovimientosLegales.addElement("" + i + columna );
            }
        }else{
            for (int i = filas+1; i<filas+3 ;i++){
                listaDeMovimientosLegales.addElement("" + i + columna );
            }
        }

        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "P";
    }
}
