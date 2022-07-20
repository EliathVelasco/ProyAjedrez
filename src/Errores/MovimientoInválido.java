package Errores;

public class MovimientoInválido extends Exception {
    public MovimientoInválido(String errorMessage) {
        super(errorMessage);
    }
}
