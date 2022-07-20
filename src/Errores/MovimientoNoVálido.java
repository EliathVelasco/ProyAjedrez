package Errores;

public class MovimientoNoVálido extends Exception {
    public MovimientoNoVálido(String errorMessage) {
        super(errorMessage);
    }
}
