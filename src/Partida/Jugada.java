package Partida;

import Errores.FilaInvalida;
import Errores.SintáxisInválida;

public class Jugada {
    private int[] coordenadasIniciales = new int[2];
    private int[] coordenadasFinales = new int[2];
    private ColorPiezas color;
    public Jugada(String jugada, ColorPiezas colorPiezas) throws FilaInvalida, SintáxisInválida {
        validarFilas(jugada);

        coordenadasIniciales[1] = transformarColumnaIngresadaEnIndice(jugada.charAt(0));
        coordenadasIniciales[0] = Character.getNumericValue(jugada.charAt(1))-1;

        coordenadasFinales[1] = transformarColumnaIngresadaEnIndice(jugada.charAt(3));
        coordenadasFinales[0] = Character.getNumericValue(jugada.charAt(3))-1;

        color = colorPiezas;
    }

    private void validarFilas(String jugada) throws SintáxisInválida, FilaInvalida {
        if (jugada.length() > 4){
            throw new SintáxisInválida("Hay demasiados datos en la jugada");
        }
        if (jugada.length() < 4){
            throw new SintáxisInválida("Faltan datos en la jugada");
        }
        if (Character.getNumericValue(jugada.charAt(1)) >= 0 && Character.getNumericValue(jugada.charAt(1)) <=Tablero.NUMERO_DE_FILAS){
            throw new FilaInvalida("La fila "+ jugada.charAt(1) + " no existe");
        }
        if (Character.getNumericValue(jugada.charAt(3)) >= 0 && Character.getNumericValue(jugada.charAt(3)) <= Tablero.NUMERO_DE_FILAS){
            throw new FilaInvalida("La fila "+ jugada.charAt(3) + " no existe");
        }
    }
    private int transformarColumnaIngresadaEnIndice(char letra) throws SintáxisInválida {

        String cadenaDeLetras = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < Tablero.NUMERO_DE_COLUMNAS; i++) {
            if (cadenaDeLetras.charAt(i) == letra) {
                return  i;
            }
        }
        throw new SintáxisInválida("La columna " + letra + " no existe");
    }

    public int getFilaInicial() {
        return coordenadasIniciales[0];
    }

    public int getColumnaInicial() {
        return coordenadasIniciales[1];
    }

    public ColorPiezas getColor() {
        return color;
    }

    public int getFilaFinal() {
        return coordenadasFinales[0];
    }

    public int getColumnaFinal() {
        return coordenadasFinales[1];
    }
}
