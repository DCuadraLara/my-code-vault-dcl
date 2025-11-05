package tarea03;

import libtarea3.Velero; // Import de la clase Velero.

// ------------------------------------------------------------
//                   Clase Controlador
// ------------------------------------------------------------
/**
 * <p>
 * Clase que representa al <strong>controlador</strong>, que será la clase que
 * utilizaremos y donde se escribirán las diferentes operaciones en veleros que
 * se nos pide en el enunciado de la tarea.
 * </p>
 *
 * @author David Cuadra Lara
 */
public class Controlador {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        String infoVelero1, infoVelero2, infoVelero3;

        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        // Creamos los 4 objetos de clase velero.
        System.out.println("-------------------------------");
        System.out.println("    --- Creando veleros ---    ");
        System.out.println("-------------------------------");

        Velero velero1, velero2, velero3, veleroIncorrecto = null;

        // Instanciar los tres veleros correctos: velero1, velero2 y velero3.
        velero1 = new Velero();
        velero2 = new Velero("Poseidón", 3, 6);
        velero3 = new Velero("Atlántico", 3, 5);

        System.out.println("Instanciando veleros correctamente...");
        System.out.println("*** Veleros instanciados correctamente ***");

        // Intentar instanciar el cuarto velero (incorrecto): veleroIncorrecto.
        // Instanciamos primer error - valor nulo.
        try {
            System.out.println("\nCreando veleros con datos incorrectos/nulos...");
            veleroIncorrecto = new Velero(null, -5, 5);
        } catch (NullPointerException e) {
            System.err.printf("Error: %s%n", e.getMessage());
        }
        // Instanciamos segundo error - IllegalArgument.
        try {
            veleroIncorrecto = new Velero("Lucas", -5, 5);
        } catch (IllegalArgumentException e) {
            System.err.printf("Error: %s%n", e.getMessage());
        }

        System.out.println();

        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        System.out.println("--------------------------------");
        System.out.println("-- Secuencia de instrucciones --");
        System.out.println("--------------------------------");

        // velero1 inicia su navegación con velocidad 10, rumbo ceñida, patrón Carlos Ruiz y tripulación 0.
        velero1.iniciarNavegacion(10, "ceñida", "Carlos Ruiz", 0);

        // velero2 inicia su navegación con velocidad 15, rumbo empopada, patrón Laura Gómez y tripulación 4.
        velero2.iniciarNavegacion(15, "empopada", "Laura Gómez", 4);

        // velero3 inicia su navegación con velocidad 12, rumbo empopada, patrón Pedro Torres y tripulación 2.
        velero3.iniciarNavegacion(12, "empopada", "Pedro Torres", 2);

        // Comprobar si el velero1 está navegando.
        System.out.printf("¿Velero1 está navegando? - %s%n",
                velero1.isNavegando() ? "Sí" : "No");
        System.out.println();

        // Mostrar el nombre y el número de mástiles de velero2
        System.out.printf("El nombre de velero2 es %s y el número de mástiles es %d%n",
                velero2.getNombreBarco(),
                velero2.getNumMastiles());
        System.out.println();

        // Mostrar el patrón y la velocidad de navegación de velero3
        System.out.printf("El patrón de velero3 es %s y la velocidad de navegación es %d nudos%n",
                velero3.getPatron(),
                velero3.getVelocidad());
        System.out.println();

        // Modificar el rumbo de velero1 a empopada y mostrarlo
        velero1.setRumbo("empopada");
        System.out.printf("Estado del rumbo actual en velero1: %s%n", velero1.getRumbo());
        System.out.println();

        // Parar la navegación de velero1 después de 120 minutos
        velero1.pararNavegacion(120);

        // Mostrar el tiempo total de navegación de velero1
        System.out.printf("Tiempo total de navegación velero1: %d minutos%n",
                velero1.getTiempoTotalNavegacionBarco());
        System.out.println();

        // Iniciar una regata entre velero2 y velero3
        try {
            System.out.printf("Resultado de la regata: %s%n",
                    velero2.iniciarRegata(velero3));
        } catch (IllegalStateException | NullPointerException e) {
            System.err.printf("Error: %s%n", e.getMessage());
        }

        // Parar la navegación de velero2 después de 90 minutos
        velero2.pararNavegacion(90);

        // Parar la navegación de velero3 después de 150 minutos
        velero3.pararNavegacion(150);

        //----------------------------------------------
        //   Mostrar información de cada velero
        //----------------------------------------------
        System.out.println("--------------------------------");
        System.out.println("  -- Información de veleros --  ");
        System.out.println("--------------------------------");

        // toString una vez existe el objeto.
        infoVelero1 = velero1.toString();
        infoVelero2 = velero2.toString();
        infoVelero3 = velero3.toString();

        // Mostrar toda la información de veleros.
        System.out.println(infoVelero1);
        System.out.println(infoVelero2);
        System.out.println(infoVelero3);

        System.out.println();

        //----------------------------------------------
        //          Llamadas a métodos estáticos
        //----------------------------------------------
        System.out.println("--------------------------------");
        System.out.println("  ---- Métodos estáticos ----  ");
        System.out.println("--------------------------------");

        // Mostrar el número total de veleros creados
        System.out.printf("Número total de veleros creados: %d%n", Velero.getNumBarcos());
        // Mostrar el número total de veleros navegando en este momento
        System.out.printf("Número total de veleros navegando en este momento: %d%n",
                Velero.getNumBarcosNavegando());

        // Mostrar el tiempo total de navegación de todos los veleros (en horas)
        System.out.printf("Tiempo total de navegación de todos los veleros: %.2f horas%n",
                Velero.getTiempoTotalNavegacion() / 60.0);

    }
}
