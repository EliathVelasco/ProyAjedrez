package Piezas;
import java.util.*;
import Partida.*;
public abstract class Pieza {

    protected ColorPiezas color;
    protected Vector listaDeMovimientosLegales;

    public Pieza(ColorPiezas color){
        this.color = color;
        this.listaDeMovimientosLegales = new Vector(1,1);
    }

    public abstract Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero);


    public ColorPiezas getColor() {
        return color;
    }

}
