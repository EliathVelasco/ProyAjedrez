package Partida;
import Errores.*;

import java.util.Scanner;

public class Jugador {

    private ColorPiezas colorPiezas;
    public Jugador(ColorPiezas colorPiezas) {
        this.colorPiezas = colorPiezas;

    }

    public Jugada ingresarJugada() throws MovimientoNoVálido, SintáxisInválida{
        Scanner scannerDelBlanco = new Scanner(System.in);
        String jugadaDelBlanco = scannerDelBlanco.next();
        Jugada jugada = new Jugada(jugadaDelBlanco, colorPiezas);
        return jugada;
    }
}