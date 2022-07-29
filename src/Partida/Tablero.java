package Partida;

import Piezas.*;
import Errores.*;

import java.util.Vector;

public class Tablero {
    private Casilla[][] casillas;


    public Tablero() {
        this.casillas = new Casilla[8][8];

        casillas[0][0] = new Casilla(new Torre(ColorPiezas.BLANCAS));
        casillas[0][7] = new Casilla(new Torre(ColorPiezas.BLANCAS));
        casillas[7][0] = new Casilla(new Torre(ColorPiezas.NEGRAS));
        casillas[7][7] = new Casilla(new Torre(ColorPiezas.NEGRAS));
        casillas[0][1] = new Casilla(new Caballo(ColorPiezas.BLANCAS));
        casillas[0][6] = new Casilla(new Caballo(ColorPiezas.BLANCAS));
        casillas[7][1] = new Casilla(new Caballo(ColorPiezas.NEGRAS));
        casillas[7][6] = new Casilla(new Caballo(ColorPiezas.NEGRAS));
        casillas[0][2] = new Casilla(new Alfil(ColorPiezas.BLANCAS));
        casillas[0][5] = new Casilla(new Alfil(ColorPiezas.BLANCAS));
        casillas[7][2] = new Casilla(new Alfil(ColorPiezas.NEGRAS));
        casillas[7][5] = new Casilla(new Alfil(ColorPiezas.NEGRAS));
        casillas[0][3] = new Casilla(new Dama(ColorPiezas.BLANCAS));
        casillas[7][3] = new Casilla(new Dama(ColorPiezas.NEGRAS));
        casillas[0][4] = new Casilla(new Rey(ColorPiezas.BLANCAS));
        casillas[7][4] = new Casilla(new Rey(ColorPiezas.NEGRAS));

        for (int i = 0; i < 8; i++) {
            casillas[1][i] = new Casilla(new Peon(ColorPiezas.BLANCAS));
            casillas[6][i] = new Casilla(new Peon(ColorPiezas.NEGRAS));
        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        System.out.println('\n');
    }

    public void actualizarTablero(int[] columna, int[] fila, ColorPiezas colorPieza) throws MovimientoNoVálido {
        Vector listaDeMovimientosLegales = new Vector(15, 5);
        if (casillas[fila[0]][columna[0]].hayPieza() && casillas[fila[0]][columna[0]].getPieza().getColor() == colorPieza) {
            listaDeMovimientosLegales = casillas[fila[0]][columna[0]].getPieza().obtenerListaDeMovimientosLegales(fila[0], columna[0], this);
        }

        String coordenadaADondeSeQuiereMover = "" + fila[1] + columna[1];
        if (listaDeMovimientosLegales.contains(coordenadaADondeSeQuiereMover)) {
            if (casillas[fila[0]][columna[0]].getPieza() instanceof Peon || casillas[fila[0]][columna[0]].getPieza() instanceof Torre || casillas[fila[0]][columna[0]].getPieza() instanceof Rey) {
                casillas[fila[0]][columna[0]].getPieza().quitarPrimerMovimiento();
            }

            if (coordenadaADondeSeQuiereMover.equals("06") && casillas[fila[0]][columna[0]].getPieza() instanceof Rey && casillas[fila[0]][columna[0]+3].getPieza().noSeHaMovido()){
                casillas[fila[1]][columna[1]].ponerPieza(new Rey(colorPieza));
                casillas[fila[0]][columna[0]+1].ponerPieza(new Torre(colorPieza));
                casillas[fila[0]][columna[0]+3].quitarPieza();
                casillas[fila[0]][columna[0]].quitarPieza();
            } else if (coordenadaADondeSeQuiereMover.equals("02") && casillas[fila[0]][columna[0]].getPieza() instanceof Rey && casillas[fila[0]][columna[0]-4].getPieza().noSeHaMovido()) {
                casillas[fila[1]][columna[1]].ponerPieza(casillas[fila[0]][columna[0]].getPieza());
                casillas[fila[0]][columna[0]-1].ponerPieza(new Torre(colorPieza));
                casillas[fila[0]][columna[0]-4].quitarPieza();
                casillas[fila[0]][columna[0]].quitarPieza();
            } else {
                casillas[fila[1]][columna[1]].ponerPieza(casillas[fila[0]][columna[0]].getPieza());
                casillas[fila[0]][columna[0]].quitarPieza();
            }


        } else {
            throw new MovimientoNoVálido("Movimiento no permitido.");
        }
    }

    public void imprimirTablero() {
        System.out.println(" a  b  c  d  e  f  g  h ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (casillas[i][j].hayPieza()) {
                    System.out.print("[" + casillas[i][j] + "]");
                } else {
                    System.out.print("[ ]");
                }

            }
            System.out.print(i + 1);
            System.out.print('\n');
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void hacerJugada(Jugada jugada) {

    }
}