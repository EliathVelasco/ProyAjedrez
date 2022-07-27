package Partida;

import Errores.FilaInvalida;
import Errores.SintáxisInválida;

public class Jugada {
    private int[] coordenadasIniciales = new int[2];
    private int[] coordenadasFinales = new int[2];
    public Jugada(String jugada) throws FilaInvalida, SintáxisInválida {
        validarFilas(jugada);

        coordenadasIniciales[0] = transformarColumnaIngresadaEnIndice(jugada.charAt(0));
        coordenadasIniciales[1] = Character.getNumericValue(jugada.charAt(1))-1;

        coordenadasFinales[0] = transformarColumnaIngresadaEnIndice(jugada.charAt(3));
        coordenadasFinales[1] = Character.getNumericValue(jugada.charAt(3))-1;
    }

    private void validarFilas(String jugada) throws SintáxisInválida, FilaInvalida {
        if (jugada.length() > 4){
            throw new SintáxisInválida("Hay demasiados datos en la jugada");
        }
        if (jugada.length() < 4){
            throw new SintáxisInválida("Faltan datos en la jugada");
        }
        if (Character.getNumericValue(jugada.charAt(1)) >= 0 && Character.getNumericValue(jugada.charAt(1)) <=8){
            throw new FilaInvalida("La fila "+ jugada.charAt(1) + " no existe");
        }
        if (Character.getNumericValue(jugada.charAt(3)) >= 0 && Character.getNumericValue(jugada.charAt(3)) <= 8){
            throw new FilaInvalida("La fila "+ jugada.charAt(3) + " no existe");
        }
    }
    private int transformarColumnaIngresadaEnIndice(char letra) throws SintáxisInválida {

        String cadenaDeLetras = "abcdefgh";

        for (int i = 0; i < 8; i++) {
            if (cadenaDeLetras.charAt(i) == letra) {
                return  i;
            }
        }
        throw new SintáxisInválida("La columna " + letra + " no existe");
    }
}
