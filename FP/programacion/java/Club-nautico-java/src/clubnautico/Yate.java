package clubnautico;

/**
 * Subclase que representa un Yate. Hereda los atributos de Embarcacion e
 * incorpora características propias como la potencia del motor, el número de
 * camarotes y su tamaño. Añade un coste adicional en la tarifa según su
 * potencia y tipo de yate.
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
enum TamañoBarcoYate {
    PEQUEÑO, MEDIANO, GRANDE, SUPERYATE, MEGAYATE
}

public class Yate extends Embarcacion {

    private int tripulantes;
    private String capitan;
    private int potenciaCV;
    private int numCamarotes;
    private TamañoBarcoYate tamaño;

    // - Constructor por defecto.
    public Yate() {
        this.tripulantes = 0;
        this.capitan = "Empty";
        this.potenciaCV = 0;
        this.numCamarotes = 0;
        this.tamaño = null;
    }

    // - Getters - Yate.
    public int getTripulantes() {
        return tripulantes;
    }

    public String getCapitan() {
        return capitan;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public TamañoBarcoYate getTamaño() {
        return tamaño;
    }

    // - Setters - Yate.
    public void setTripulantes(int tripulantes) {
        this.tripulantes = tripulantes;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    public void setTamaño(String tamañoStr) {
        this.tamaño = TamañoBarcoYate.valueOf(tamañoStr);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                """
        Tripulantes: %d
        Capitán: %s
        Potencia (CV): %d
        Camarotes: %d
        Tamaño Yate: %s
        """,
                tripulantes,
                capitan,
                potenciaCV,
                numCamarotes,
                tamaño
        );
    }

}