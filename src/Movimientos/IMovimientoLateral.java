package Movimientos;

import Partida.Tablero;

import java.util.Vector;

public interface IMovimientoLateral {
    Vector obtenerJugadasLegalesLaterales(int filaInicial, int columnaInicial, Tablero tablero);
}
