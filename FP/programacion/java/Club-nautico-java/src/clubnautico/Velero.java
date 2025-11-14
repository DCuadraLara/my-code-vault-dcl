package clubnautico;

/**
 * Subclase que representa un Velero. Hereda los atributos de Embarcacion e
 * incluye el número de mástiles. Añade un coste adicional en la tarifa según el
 * número de mástiles.
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
enum TamañoBarcoVelero {
    PEQUEÑO, MEDIANO, GRANDE
}

public class Velero extends Embarcacion {

    private int numMastiles;
    private int tripulantes;
    private String capitan;
    private TamañoBarcoVelero tamaño;

    // - Constructor por defecto.
    public Velero() {
        this.numMastiles = 0;
        this.tripulantes = 0;
        this.capitan = "Empty";
        this.tamaño = null;
    }

    // Reemplazamos el metodo padre añadiendo reglas adicionales.
    @Override
    public double calcularTarifaBase() {
        double tarifa = super.calcularTarifaBase(); // Llamamos al método de clase padre.
        return tarifa + numMastiles * 20;
    }

    // - Getters - Velero.
    public int getNumMastiles() {
        return numMastiles;
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public String getCapitan() {
        return capitan;
    }

    public TamañoBarcoVelero getTamaño() {
        return tamaño;
    }

    // - Setters - Velero.
    public void setNumMastiles(int numMastiles) {
        this.numMastiles = numMastiles;
    }

    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public void setTamaño(String tamañoStr) {
        this.tamaño = TamañoBarcoVelero.valueOf(tamañoStr);
    }

    // Método toString para mostrar datos.
    @Override
    public String toString() {
        return super.toString() + String.format(
                """
        Mástiles: %d
        Tripulantes: %d
        Capitán: %s
        Tamaño velero: %s
        """,
                numMastiles, tripulantes, capitan, tamaño
        );
    }

}
