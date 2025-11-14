package clubnautico;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 * ------------------------------------------------------------ Proyecto: Club
 * Náutico – Gestión de Embarcaciones
 * ------------------------------------------------------------ Asignatura:
 * Programación (Temas 1 a 3) Autor: David Cuadra Lara Fecha: Noviembre 2025
 * ------------------------------------------------------------
 *
 * <p>
 * <strong>Descripción general:</strong></p>
 * <p>
 * Este programa permite gestionar un pequeño club náutico, aplicando los
 * conceptos fundamentales de los primeros tres temas del módulo de Programación
 * (DAM):
 * </p>
 *
 * <ul>
 * <li><strong>Tema 1:</strong> Fundamentos de Java (tipos de datos, variables,
 * operadores, entrada/salida).</li>
 * <li><strong>Tema 2:</strong> Estructuras de control (condicionales, bucles,
 * switch).</li>
 * <li><strong>Tema 3:</strong> Programación orientada a objetos (clases,
 * objetos, métodos, encapsulación).</li>
 * </ul>
 *
 * <p>
 * <strong>Funcionalidad principal:</strong></p>
 * <p>
 * El sistema permite registrar distintos tipos de embarcaciones (como Veleros o
 * Yates), almacenar su información en memoria, mostrar un listado completo de
 * embarcaciones registradas, modificar una embarcación ya creada, borrar
 * embarcaciones, buscar una embarcación por ID y calcular tarifas
 * personalizadas según su tipo, año de fabricación y si pertenece a un socio
 * (descuento aplicado).
 * </p>
 *
 * <p>
 * <strong>Menú principal:</strong></p>
 * <ul>
 * <li>Registrar embarcación.</li>
 * <li>Mostrar embarcaciones registradas.</li>
 * <li>Modificar embarcaciones registradas.</li>
 * <li>Eliminar embarcaciones registradas.</li>
 * <li>Calcular tarifas y descuentos.</li>
 * <li>Buscar embarcación por ID.</li>
 * <li>Salir.</li>
 * </ul>
 *
 * <p>
 * <strong>Lógica del programa:</strong></p>
 * <p>
 * Los datos se gestionan mediante clases que representan cada tipo de
 * embarcación. Se utilizan estructuras de control como bucles y condicionales
 * para gestionar el menú y validar datos introducidos por el usuario. Las
 * tarifas se calculan a partir de la eslora y la antigüedad del barco,
 * aplicando descuentos del 15% para socios del club. También se incluyen
 * métodos auxiliares para mantener el código limpio, modular y fácil de
 * mantener.
 * </p>
 *
 * <p>
 * <strong>Objetivos de aprendizaje:</strong></p>
 * <ul>
 * <li>Aplicar las bases del lenguaje Java de forma práctica.</li>
 * <li>Comprender la lógica de la POO (clases, constructores, métodos,
 * herencia...).</li>
 * <li>Integrar estructuras de control en un programa realista.</li>
 * <li>Desarrollar código modular, legible y mantenible.</li>
 * </ul>
 *
 * <p>
 * <strong>Nivel extra (opcional):</strong></p>
 * <p>
 * Como ampliación, se pueden añadir mejoras como persistencia en archivos JSON,
 * gestión avanzada de IDs automáticos, excepciones personalizadas o
 * estadísticas generales del club.
 * </p>
 *
 * @author David Cuadra Lara
 * @version 1.1
 * @since 2025-11
 */
public class ClubNautico {

    // Lista donde guardamos embarcaciones.
    private static final ArrayList<Embarcacion> embarcaciones = new ArrayList<>();

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        boolean finPrograma = false;

        // Init Scanner.
        Scanner sc = new Scanner(System.in);

        // - Main Menú.
        System.out.println("----------------");
        System.out.println("** CLUB NAUTICO **");
        System.out.println("----------------");

        System.out.print("""
        1 - Registrar embarcación.
        2 - Mostrar embarcaciones.
        3 - Modificar embarcación.
        4 - Eliminar embarcación.
        5 - Calcular tarifas y descuentos.
        6 - Buscar embarcacion por ID.
        7 - Salir.
        """);

        System.out.println("--");

        while (!finPrograma) {
            // - Selecciona opción menú.
            int menu = elegirMenu(sc);

            switch (menu) {
                case 1:
                    // Llamamos al método.
                    Embarcacion barco = crearEmbarcacion(sc); // Creamos objeto barco

                    // No añadimos null
                    if (barco != null) {
                        embarcaciones.add(barco); // Añadimos en lista

                        System.out.println("\nRegistrando embarcacion...\n");
                        System.out.println("*** Embarcación registrada correctamente ***");
                    } else {
                        System.out.println("*** No se ha podido registrar la embarcación. ***");
                    }
                    break;
                case 2:
                    mostrarEmbarcaciones(embarcaciones);
                    break;
                case 3:
                    Embarcacion barcoModificado = buscarBarcoArray(sc);
                    modificarDatos(barcoModificado, sc);
                    System.out.println("Modificando datos...");

                    System.out.printf(
                            "ID: %s | Nombre: %s | Tipo: %s | Eslora: %.2f m | Fecha: %s | Socio: %s%n",
                            barcoModificado.getId(),
                            barcoModificado.getNombre(),
                            barcoModificado.getTipo(),
                            barcoModificado.getEslora(),
                            barcoModificado.getFechaRegistro(),
                            barcoModificado.getEsSocio() ? "SI" : "NO"
                    );
                    break;
                case 4:
                    Embarcacion barcoEliminar = buscarBarcoArray(sc);
                    eliminarEmbarcacion(barcoEliminar, sc);
                    break;
                case 5:
                    System.out.println("Función de cálculo de tarifas todavía no implementada.");
                    //WIP
                    break;
                case 6:
                    System.out.println("Función de búsqueda por nombre todavía no implementada.");
                    //WIP
                    break;
                case 7:
                    sc.close(); // Cerramos scanner.
                    System.out.println("Cerrando programa...\n");
                    finPrograma = true;
                    break;
                default:
                    break;
            }

            if (!finPrograma) {
                // -- ¿Continuar programa? --
                System.out.println("\n===========================================");
                System.out.println("¿Quiere continuar realizando gestiones? - SI / NO");
                System.out.println("===========================================");
                String seguirGestiones = sc.nextLine().trim().toUpperCase();

                switch (seguirGestiones) {
                    case "SI":
                        finPrograma = false;
                        System.out.println();
                        break;
                    case "NO":
                        finPrograma = true;
                        break;
                    default:
                        System.err.println("Error: valor incorrecto.");
                        finPrograma = true;
                        break;
                }
            }

        }
    }

    public static int elegirMenu(Scanner sc) {
        boolean menuValido = false;
        int menu = 0;

        do {
            try {
                System.out.print("Introduce una opcion valida 1-7: ");
                menu = sc.nextInt();

                System.out.println();

                if (menu > 0 && menu < 8) {
                    menuValido = true;
                } else {
                    menuValido = false;
                    System.out.println("Introduce un número válido.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Debes introducir un número entero.");
            } finally {
                sc.nextLine();
            }
        } while (!menuValido);
        return menu;
    }

    public static Embarcacion crearEmbarcacion(Scanner sc) {
        System.out.println("***======================================");
        System.out.println("*** Registro de nueva embarcación ***");
        System.out.println("***======================================");

        // Primero pide tipo.
        String tipoStr = InputUtils.pedirStringNoVacio(
                sc, "Tipo de embarcación [VELERO | YATE | PESQUERA | DEPORTIVA]"
        ).toUpperCase(); // VELERO / YATE / PESQUERA / DEPORTIVA.
        Embarcacion barco;

        // Crear objeto de clase correcta.
        switch (tipoStr) {
            case "VELERO":
                barco = new Velero();
                break;
            case "YATE":
                barco = new Yate();
                break;
            case "PESQUERA":
                barco = new Pesquera();
                break;
            case "DEPORTIVA":
                barco = new Deportiva();
                break;
            default:
                System.out.println("El nombre introducido no coincide con ningún tipo.");
                barco = null;
                break;
        }

        // Check valida posible error null.
        if (barco == null) {
            System.out.print("Error al definir tipo.");
            return null;
        }

        // Datos comunes de embarcacion.
        System.out.printf("ID - %s%n", barco.getId()); // Guardamos ID.
        barco.setNombre(InputUtils.pedirStringNoVacio(sc, "Nombre del barco")); // Pedir y set nombre.
        barco.setEslora(InputUtils.pedirDoublePositivo(sc, "Eslora(m)")); // Pedir y set eslora.
        System.out.printf("Fecha - %s%n", barco.getFechaRegistro()); // Set fecha actual.
        barco.setEsSocio(InputUtils.pedirBoolean(sc, "¿Es socio?")); // Pedir y set socio.
        barco.setTipo(tipoStr); // Usamos el tipo elegido.

        // Datos específicos - VELERO.
        if (barco instanceof Velero vel) {
            vel.setNumMastiles(InputUtils.pedirEnteroPositivo(sc, "Número de mastiles")); // Pedir y set número de mastiles.
            vel.setTripulantes(InputUtils.pedirEnteroPositivo(sc, "Número de tripulantes")); // Pedir y set número de tripulantes.
            vel.setCapitan(InputUtils.pedirStringNoVacio(sc, "Nombre de capitán")); // Pedir y set número de tripulantes.
            vel.setTamaño(InputUtils.pedirStringNoVacio(sc, "Tamaño de velero").toUpperCase()); //Pedir y set tamaño.
        }

        // Datos específicos - YATE.
        if (barco instanceof Yate yat) {
            yat.setTripulantes(InputUtils.pedirEnteroPositivo(sc, "Número de tripulantes"));
            yat.setCapitan(InputUtils.pedirStringNoVacio(sc, "Nombre de capitán"));
            yat.setPotenciaCV(InputUtils.pedirEnteroPositivo(sc, "Potencia(CV)"));
            yat.setNumCamarotes(InputUtils.pedirEnteroPositivo(sc, "Número de camarotes"));
            yat.setTamaño(InputUtils.pedirStringNoVacio(sc, "Tamaño de yate").toUpperCase());
        }

        // Datos específicos - PESQUERA.
        if (barco instanceof Pesquera pes) {
            pes.setTripulantes(InputUtils.pedirEnteroPositivo(sc, "Número de tripulantes"));
            pes.setCapitan(InputUtils.pedirStringNoVacio(sc, "Nombre de capitán"));
            pes.setCapacidadToneladas(InputUtils.pedirEnteroPositivo(sc, "Capacidad de carga(t)"));
            pes.setLicenciaEspecial(InputUtils.pedirBoolean(sc, "¿Tiene licencia especial?"));
            pes.setZonaPesca(InputUtils.pedirStringNoVacio(sc, "Zona de pesca"));
            pes.setTamaño(InputUtils.pedirStringNoVacio(sc, "Tamaño de pesquera").toUpperCase());
        }

        // Datos específicos - DEPORTIVA.
        if (barco instanceof Deportiva depor) {
            depor.setTripulantes(InputUtils.pedirEnteroPositivo(sc, "Número de tripulantes"));
            depor.setCapitan(InputUtils.pedirStringNoVacio(sc, "Nombre de capitán"));
            depor.setEsCompeticion(InputUtils.pedirBoolean(sc, "¿Es de competición?"));
            depor.setPotenciaCV(InputUtils.pedirEnteroPositivo(sc, "Potencia(CV)"));
            depor.setModelo(InputUtils.pedirStringNoVacio(sc, "Modelo de la deportiva"));
            depor.setTamaño(InputUtils.pedirStringNoVacio(sc, "Tamaño de deportiva").toUpperCase());
        }

        return barco;
    }

    // - Mostramos embarcaciones creadas.
    public static void mostrarEmbarcaciones(ArrayList<Embarcacion> embarcaciones) {

        if (embarcaciones.isEmpty()) {
            System.out.println("*** No hay embarcaciones registradas ***");
            return;
        }

        System.out.println("=== LISTADO COMPLETO DE EMBARCACIONES ===");

        for (Embarcacion barco : embarcaciones) {
            System.out.println(barco);
            System.out.println("------------------------------");
        }
    }

    // - Buscar por ID.
    public static Embarcacion buscarId(Scanner sc) {
        System.out.println("Introduce la ID del barco a buscar: ");
        String idTemp = sc.nextLine().trim();

        // Revisamos array de barco - nombre para encontrar uno igual con equals.
        for (int i = 0; i < embarcaciones.size(); i++) {
            Embarcacion barco = embarcaciones.get(i); // Obtenemos el barco actual.
            if (barco != null && idTemp.equalsIgnoreCase(barco.getId())) {
                return barco;
            }
        }
        return null; // Si no lo encuentra Null.
    }

    // - Modificar datos de embarcacion.
    public static void modificarDatos(Embarcacion barco, Scanner sc) {
        if (barco == null) {
            System.out.println("No se ha encontrado ninguna embarcación con esa ID.");
            return;
        }

        System.out.printf(
                "ID: %s | Nombre: %s | Tipo: %s | Eslora: %.2f m | Fecha: %s | Socio: %s%n",
                barco.getId(),
                barco.getNombre(),
                barco.getTipo(),
                barco.getEslora(),
                barco.getFechaRegistro(),
                barco.getEsSocio() ? "SI" : "NO"
        );

        System.out.print("""
        == ¿Qué quiere modificar? ==
                
        1 - Nombre.
        2 - Eslora.
        3 - Socio.
        4 - Fecha.
        5 - Tipo.
        """);
        String modificarTemp = sc.nextLine().strip().toLowerCase();

        switch (modificarTemp) {
            case "nombre":
            case "1":
                barco.setNombre(
                        InputUtils.pedirStringNoVacio(sc, "Nuevo nombre de barco")
                );
                break;
            case "eslora":
            case "2":
                barco.setEslora(
                        InputUtils.pedirDoublePositivo(sc, "Nueva eslora del barco (m)")
                );
                break;
            case "socio":
            case "3":
                barco.setEsSocio(
                        InputUtils.pedirBoolean(sc, "¿Es socio actualmente?")
                );
                break;
            case "fecha":
            case "4":
                try {
                System.out.println("Actualizando fecha, introduce valores(dd-MM-yyyy): ");
                String fechaEntrada = sc.nextLine();

                barco.setModificarFecha(fechaEntrada);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            break;
            case "tipo":
            case "5":
                barco.setTipo(
                        InputUtils.pedirStringNoVacio(
                                sc, "Nuevo tipo de embarcación: [VELERO | YATE | PESQUERA | DEPORTIVA] "
                        )
                );
                break;
            default:
                System.err.println("Error: Input incorrecto.");
        }
    }

    // - Eliminar embarcación.
    public static void eliminarEmbarcacion(Embarcacion barco, Scanner sc) {
        if (barco == null) {
            System.out.println("No se ha encontrado ninguna embarcación con esa ID.");
            return;
        }

        embarcaciones.remove(barco); // Eliminamos barco

        System.out.println("Embarcación eliminada correctamente.");
    }

    // - Buscar barco ArrayList.
    public static Embarcacion buscarBarcoArray(Scanner sc) {
        if (embarcaciones.isEmpty()) {
            System.out.println("No hay embarcaciones registradas. Imposible borrar nada.");
            return null;
        }

        Embarcacion BarcoEncontrado = buscarId(sc); // buscamos el barco.

        if (BarcoEncontrado == null) {
            System.out.println("No existe embarcacion con esa ID.");
        }

        return BarcoEncontrado;
    }

}
