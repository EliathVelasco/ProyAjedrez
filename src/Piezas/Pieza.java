package Piezas;
import java.util.*;
import Partida.*;
public abstract class Pieza {
    protected ColorPiezas color;
    public Pieza(ColorPiezas color){
        System.out.println("NOMBRE");
        this.color = color;
    }

    public abstract Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero);


    public ColorPiezas getColor() {
        return color;
    }

}
