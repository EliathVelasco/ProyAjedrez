package Partida;
import Errores.*;

public class Jugador {

    private ColorPiezas colorPiezas;
    public Jugador(ColorPiezas colorPiezas) {
        this.colorPiezas = colorPiezas;

    }

    public void ingresarJugada(String casillas, Tablero tablero) throws MovimientoNoVálido, SintáxisInválida {

        if (casillas.length() !=4){
            throw new SintáxisInválida("Coordenadas incompletas");
        }

        int[] columna = new int[2];
        int[] fila = new int[2];

        columna[0] = transformarColumnaIngresadaEnIndice(casillas.charAt(0));
        columna[1] = transformarColumnaIngresadaEnIndice(casillas.charAt(2));

        fila[0] = Character.getNumericValue(casillas.charAt(1))-1;
        fila[1] = Character.getNumericValue(casillas.charAt(3))-1;

        tablero.actualizarTablero(columna, fila, colorPiezas);
        
    }

    private int transformarColumnaIngresadaEnIndice(char letra) throws SintáxisInválida {

        String cadenaDeLetras = "abcdefgh";

        for (int i = 0; i < 8; i++) {
            if (cadenaDeLetras.charAt(i) == letra) {
                return  i;
            }
        }
        throw new SintáxisInválida("Ingreso no válido.");
    }

}
