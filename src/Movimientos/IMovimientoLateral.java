package Movimientos;

import Partida.Tablero;

import java.util.Vector;

public interface IMovimientoLateral {
    static Vector obtenerJugadasLegales(int filaInicial, int columnaInicial, Tablero tablero) {
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
