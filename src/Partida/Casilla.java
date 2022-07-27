package Partida;

import Errores.MovimientoNoVálido;
import Piezas.Pieza;

import java.util.ArrayList;

public class Casilla {
    private Pieza pieza;

    public Casilla(Pieza pieza) {
        this.pieza = pieza;
    }
    public Casilla() {
        this.pieza = null;
    }

    public boolean hayPieza(){
        return pieza != null;
    }

    @Override
    public String toString() {
        return pieza + "";
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void quitarPieza() {
        this.pieza = null;
    }

    public void ponerPieza(Pieza piezaNueva) {
        this.pieza = piezaNueva;
    }


    public ColorPiezas getColorDePieza() {
        return pieza.getColor();
    }

    public ArrayList<String> movimientosDePieza(Jugada jugada) throws MovimientoNoVálido {
        return pieza.obtenerMovimientosLegales(jugada);
    }
}
