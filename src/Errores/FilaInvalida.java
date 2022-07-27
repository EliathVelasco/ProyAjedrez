package Errores;

public class FilaInvalida extends Throwable {
    public FilaInvalida(String mensaje) {
        super(mensaje);
    }
}
