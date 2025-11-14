package clubnautico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una embarcación genérica dentro del club náutico.
 * Contiene los datos comunes a todos los tipos de barcos, así como métodos para
 * calcular tarifas base y aplicar descuentos.
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
enum TipoEmbarcacion {
    VELERO, YATE, PESQUERA, DEPORTIVA
}

public class Embarcacion {

    private static int contador = 0; // Contador embarcaciones
    private final String ID; // identificador embarcación;

    private String nombre;
    private double eslora;
    private LocalDate fechaRegistro;
    private boolean esSocio;
    private TipoEmbarcacion tipo;

    // Constructor por defecto
    public Embarcacion() {
        this.ID = calcularId(); //generamos id automático

        this.nombre = "";
        this.eslora = 0.0;
        this.fechaRegistro = LocalDate.now();
        this.esSocio = false;
        this.tipo = null;
    }

    public double calcularTarifaBase() {
        // Eslora * 10 + año de registro * 2
        return eslora * 10 + fechaRegistro.getYear() * 2;
    }

    public double aplicarDescuento(double tarifa) {
        // Devuelve tarifa con descuento si la condicion es true.
        return esSocio ? tarifa * 0.85 : tarifa; // WIP
    }

    private String calcularId() {
        contador++;
        return "A" + String.format("%03d", contador); //A001, A002...
    }

    // Getters - Embarcación.
    public String getId() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getEslora() {
        return eslora;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public boolean getEsSocio() {
        return esSocio;
    }

    public TipoEmbarcacion getTipo() {
        return tipo;
    }

    // Setters - Embarcación.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setModificarFecha(String fechaRegistro) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // formato a seguir
        this.fechaRegistro = LocalDate.parse(fechaRegistro, f);
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }

    public void setTipo(String stringTipo) {
        this.tipo = TipoEmbarcacion.valueOf(stringTipo); // convertimos string a enum.
    }

    // Método toString para mostrar datos.
    @Override
    public String toString() {
        return String.format(
                """
        ------------------------------
        ID: %s
        Nombre: %s
        Tipo: %s
        Eslora: %.2f m
        Fecha registro: %s
        Socio: %s
        """,
                getId(),
                getNombre(),
                getTipo(),
                getEslora(),
                getFechaRegistro(),
                getEsSocio() ? "SI" : "NO"
        );
    }

}
