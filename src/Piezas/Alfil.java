package Piezas;

import java.util.*;

import Errores.MovimientoNoVálido;
import Movimientos.IMovimientoDiagonal;
import Partida.*;

public class Alfil extends Pieza {
    public Alfil(ColorPiezas color) {
        super(color, 3);
    }

    /*@Override
    public Vector obtenerListaDeMovimientosLegales(int fila, int columna, Tablero tablero) {
        return obtenerJugadasLegalesDiagonales(fila, columna, tablero);
    }*/

    @Override
    public ArrayList<String> obtenerMovimientosLegales(Jugada jugada) throws MovimientoNoVálido {
        ArrayList<String> movimientos = new ArrayList<>();
        String comprobacion = "" + jugada.getFilaFinal() + jugada.getColumnaFinal();

        int auxColumna = jugada.getColumnaInicial() + 1;

        //Movimiento derecha hacia abajo
        for (int i = jugada.getFilaInicial() + 1; i < 8; i++) {
            String aux = "" + i + auxColumna;
            movimientos.add(aux);
            if (comprobacion == aux) {
                return movimientos;
            }
            if (auxColumna < 7) {
                auxColumna++;
            } else {
                break;
            }
        }
        movimientos.clear();

        auxColumna = jugada.getColumnaFinal() + 1;
        for (int i = jugada.getFilaInicial() - 1; i >= 0; i--) {
            String aux = "" + i + auxColumna;
            movimientos.add(aux);
            if (comprobacion == aux) {
                return movimientos;
            }
            if (auxColumna < 7) {
                auxColumna++;
            } else {
                break;
            }
        }

        movimientos.clear();

        auxColumna = jugada.getColumnaInicial() - 1;
        for (int i = jugada.getFilaInicial() + 1; i < 8; i++) {
            String aux = "" + i + auxColumna;
            movimientos.add(aux);
            if (comprobacion == aux) {
                return movimientos;
            }
            if (auxColumna > 0) {
                auxColumna--;
            } else {
                break;
            }
        }

        movimientos.clear();

        auxColumna = jugada.getColumnaInicial() - 1;
        for (int i = jugada.getFilaInicial() - 1; i >= 0; i--) {
            String aux = "" + i + auxColumna;
            movimientos.add(aux);
            if (comprobacion == aux) {
                return movimientos;
            }
            if (auxColumna > 0) {
                auxColumna--;
            } else {
                break;
            }
        }
        throw new MovimientoNoVálido("La pieza no se puede hacia donde ha elegido");
    }


    @Override
    public String toString() {
        return "A";
    }
}