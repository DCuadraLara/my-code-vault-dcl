package clubnautico;

/**
 * Subclase que representa una embarcación Pesquera. Hereda los atributos de
 * Embarcacion e incluye información específica como la capacidad de carga, la
 * zona de pesca y la licencia especial. Añade un coste adicional en la tarifa
 * según su capacidad y permisos.
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
enum TamañoBarcoPesquera {
    PEQUEÑO, MEDIANO, GRANDE
}

public class Pesquera extends Embarcacion {

    private int tripulantes;
    private String capitan;
    private int capacidadToneladas;
    private boolean licenciaEspecial;
    private String zonaPesca;
    private TamañoBarcoPesquera tamaño;

    // - Constructor por defecto.
    public Pesquera() {
        this.tripulantes = 0;
        this.capitan = "Empty";
        this.capacidadToneladas = 0;
        this.licenciaEspecial = false;
        this.zonaPesca = "Empty";
        this.tamaño = null;
    }

    // - Getters - Pesquera.
    public int getTripulantes() {
        return tripulantes;
    }

    public String getCapitan() {
        return capitan;
    }

    public int getCapacidadToneladas() {
        return capacidadToneladas;
    }

    public boolean getLicenciaEspecial() {
        return licenciaEspecial;
    }

    public String getZonaPesca() {
        return zonaPesca;
    }

    public TamañoBarcoPesquera getTamaño() {
        return tamaño;
    }

    // - Setters - Pesquera.
    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public void setCapacidadToneladas(int capacidadToneladas) {
        this.capacidadToneladas = capacidadToneladas;
    }

    public void setLicenciaEspecial(boolean licenciaEspecial) {
        this.licenciaEspecial = licenciaEspecial;
    }

    public void setZonaPesca(String zonaPesca) {
        this.zonaPesca = zonaPesca;
    }

    public void setTamaño(String tamañoStr) {
        this.tamaño = TamañoBarcoPesquera.valueOf(tamañoStr);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                """
        Tripulantes: %d
        Capitán: %s
        Capacidad de carga (t): %d
        Licencia especial: %s
        Zona de pesca: %s
        Tamaño Pesquera: %s
        """,
                tripulantes,
                capitan,
                capacidadToneladas,
                licenciaEspecial ? "SI" : "NO",
                zonaPesca,
                tamaño
        );
    }

}
