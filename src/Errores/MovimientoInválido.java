package Errores;

public class PiezaNoCorrespondiente extends Exception {
    public PiezaNoCorrespondiente(String errorMessage) {
        super(errorMessage);
    }
}
