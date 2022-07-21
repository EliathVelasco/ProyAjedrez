package Movimientos;

import Partida.Tablero;
import java.util.Vector;

public interface IMovimientoDiagonal {
    Vector obtenerJugadasLegalesDiagonales(int filaInicial, int columnaInicial, Tablero tablero);
}
