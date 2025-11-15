package clubnautico;

/**
 * Subclase que representa una embarcación Deportiva. Hereda los atributos de
 * Embarcacion e incorpora características propias como la potencia del motor,
 * el número de plazas y si está preparada para competición. Añade un coste
 * adicional en la tarifa según su potencia y uso deportivo.
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
enum TamañoBarcoDeportiva {
    PEQUEÑO, MEDIANO, GRANDE
}

public class Deportiva extends Embarcacion {

    private int tripulantes;
    private String capitan;
    private int potenciaCV;
    private boolean esCompeticion;
    private String modelo;
    private TamañoBarcoDeportiva tamaño;

    // - Constructor por defecto.
    public Deportiva() {
        this.tripulantes = 0;
        this.capitan = "Empty";
        this.potenciaCV = 0;
        this.esCompeticion = false;
        this.modelo = "Empty";
        this.tamaño = null;
    }

    // - Getters - Deportiva.
    public int getTripulacion() {
        return tripulantes;
    }

    public String getCapitan() {
        return capitan;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public boolean getEsCompeticion() {
        return esCompeticion;
    }

    public String getModelo() {
        return modelo;
    }

    public TamañoBarcoDeportiva getTamaño() {
        return tamaño;
    }

    // - Setters - Deportiva.
    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    public void setEsCompeticion(boolean esCompeticion) {
        this.esCompeticion = esCompeticion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTamaño(String tamañoStr) {
        this.tamaño = TamañoBarcoDeportiva.valueOf(tamañoStr);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                """
        Tripulantes: %d
        Capitán: %s
        Potencia (CV): %d
        Competición: %s
        Modelo: %s
        Tamaño Deportiva: %s
        """,
                tripulantes,
                capitan,
                potenciaCV,
                esCompeticion ? "SI" : "NO",
                modelo,
                tamaño
        );
    }

}
