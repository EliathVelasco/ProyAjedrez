package Piezas;

import java.util.*;
import Partida.*;

public class Peon extends Pieza {
    public Peon(ColorPiezas color) {
        super(color);
    }

    @Override
    public Vector obtenerListaDeMovimientosLegales(int filas, int columna, Tablero tablero) {
        this.listaDeMovimientosLegales.removeAllElements();
        if (color == ColorPiezas.NEGRAS){
            for (int i = filas-1; i>filas-3 ;i--){
                this.listaDeMovimientosLegales.addElement("" + i + columna );
            }
        }else{
            for (int i = filas+1; i<filas+3 ;i++){
                this.listaDeMovimientosLegales.addElement("" + i + columna );
            }
        }

        /*for (int j = 0; j < listaDeMovimientosLegales.size(); j++){
            System.out.println(listaDeMovimientosLegales.get(j));
        }*/
        return listaDeMovimientosLegales;
    }


    @Override
    public String toString() {
        return "P";
    }
}
