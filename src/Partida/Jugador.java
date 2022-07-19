package Partida;
import Errores.*;

public class Jugador {

    private ColorPiezas colorPiezas;
    public Jugador(ColorPiezas colorPiezas) {
        this.colorPiezas = colorPiezas;

    }

    public void ingresarJugada(String casillas, Tablero tablero) throws PiezaNoCorrespondiente, CoordenadasInválidas {

        if (casillas.length() !=4){
            throw new CoordenadasInválidas("Coordenadas incompletas");
        }

        int[] columna = new int[2];
        int[] fila = new int[2];

        columna[0] = transformarColumnaIngresadaEnIndice(casillas.charAt(0));
        columna[1] = transformarColumnaIngresadaEnIndice(casillas.charAt(2));

        fila[0] = Character.getNumericValue(casillas.charAt(1))-1;
        fila[1] = Character.getNumericValue(casillas.charAt(3))-1;

        tablero.actualizarTablero(columna, fila, colorPiezas);
        
    }

    private int transformarColumnaIngresadaEnIndice(char letra) throws CoordenadasInválidas {

        String cadenaDeLetras = "abcdefgh";

        for (int i = 0; i < 8; i++) {
            if (cadenaDeLetras.charAt(i) == letra) {
                return  i;
            }
        }
        throw new CoordenadasInválidas("Coordenada ingresada no existe");
    }

}
