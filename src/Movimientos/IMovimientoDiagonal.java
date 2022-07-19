package Movimientos;

import Partida.Tablero;

import java.util.Vector;

public interface IMovimientoDiagonal {
    static Vector obtenerJugadasLegales(int filaInicial, int columnaInicial, Tablero tablero){
        Vector listaDeJugadas = new Vector(1,1);

        int auxColumna1 = columnaInicial+1;


        //Movimiento derecha hacia abajo
        for (int i = filaInicial+1; i < 8; i++){
            if (!(tablero.getCasillas()[i][auxColumna1].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna1);
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna1].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna1);
                break;
            } else {
                break;
            }
            if (auxColumna1 < 8){
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
            } else if (tablero.getCasillas()[i][auxColumna1].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna1].getPieza().getColor() != tablero.getCasillas()[i][auxColumna1].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna1);
                break;
            } else {
                break;
            }
            if (auxColumna1 < 8){
                auxColumna1++;
            } else {
                break;
            }
        }


        int auxColumna2 = columnaInicial - 1 ;
        for (int i = filaInicial+1; i < 8; i++){
            if (!(tablero.getCasillas()[i][auxColumna2].hayPieza())) {
                listaDeJugadas.addElement("" + i + auxColumna2);
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[i][auxColumna2].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
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
            } else if (tablero.getCasillas()[i][auxColumna2].hayPieza() && tablero.getCasillas()[filaInicial][auxColumna2].getPieza().getColor() != tablero.getCasillas()[i][auxColumna2].getPieza().getColor()) {
                listaDeJugadas.addElement("" + i + auxColumna2);
                break;
            } else {
                break;
            }
            if (auxColumna2 >= 0){
                auxColumna2--;
            } else {
                break;
            }
        }
        return listaDeJugadas;
    }
}
