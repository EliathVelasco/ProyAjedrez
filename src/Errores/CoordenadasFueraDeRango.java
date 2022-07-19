package Errores;

public class CoordenadasFueraDeRango extends Throwable {
    public CoordenadasFueraDeRango(String message) {
        super(message);
    }
}
