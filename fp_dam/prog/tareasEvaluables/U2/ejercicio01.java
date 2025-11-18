package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 1. Gestión de un Gimnasio.
 *
 * Este programa permite gestionar los diferentes tipos de matrículas del
 * gimnasio. Se evalúan según funcionalidades:
 *
 * Funcionalidades: 1 - Calcular PVP de cada tipo de matrícula. 2 - Aplicar
 * oferta a un tipo de matrícula sobre precio base. 3 - Calcular importe total
 * de matrículas realizadas. 4 - Salir.
 *
 * Extra: Al finalizar podemos escoger si seguir o no realizando cálculos.
 *
 * @author David Cuadra Lara.
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final double PRECIO_BASE_FITNESS = 10.0;
        final double PRECIO_BASE_YOGA = 15.0;
        final double PRECIO_BASE_MUSCULACION = 20.0;
        final String MONEDA = "Euros";

        // Variables de entrada
        int seleccionMenu = 0;
        int seleccionMatricula = 0;
        int ivaFitness = 0, ivaYoga = 0, ivaMusculacion = 0;
        int porcentajeDescuento = 0;
        int cantidadFitness = 0, cantidadYoga = 0, cantidadMusculacion = 0;

        // Variables de salida
        double pvpFitness = 0.0;
        double pvpYoga = 0.0, pvpMusculacion = 0.0, pvpOferta = 0.0;
        double importeTotal = 0.0;
        String nombreMatricula = ""; // Tipo de matrícula seleccionada.

        //Variables auxiliares
        boolean opcionValida, ivaValido;
        boolean matriculaValida = false, porcentajeValido = false, cantidadValida = false;
        boolean cerrarPrograma = false, seguirGestiones = false;
        int i;

        String continuarGestion = ""; // Variable para realizar más funciones.

        // Clase Scanner para petición de datos de entrada
        Scanner sc = new Scanner(System.in);

        do {
            // Reseteamos por si hacemos alguna otra gestión.
            opcionValida = ivaValido = matriculaValida = porcentajeValido = cantidadValida = false;
            cerrarPrograma = seguirGestiones = false;

            // ----------------------------
            // Menú principal.
            // ----------------------------
            System.out.println("EJERCICIO 1: GESTIÓN DE UN GIMNASIO");
            System.out.println("----------------------------------");

            System.out.print("""
            Precio de la matrícula tipo 1. Fitness: 10.0 €
            Precio de la matrícula tipo 2. Yoga: 15.0 €
            Precio de la matrícula tipo 3. Musculación: 20.0 €                

            --- MENÚ DE OPERACIONES ---
            1 - Calcular el PVP de cada tipo de matrícula.
            2 - Aplicar oferta sobre el precio base (sin iva).
            3 - Calcular importe total de matrículas realizadas (sin iva).
            4 - Salir.
            """);
            System.out.println("...");

            //----------------------------------------------
            //                Entrada de datos 
            //----------------------------------------------
            // Selección de opción de menú, hacemos check de la entrada.
            do {
                System.out.print("Introduce la opción a realizar: ");
                seleccionMenu = sc.nextInt();

                if (seleccionMenu > 0 && seleccionMenu < 5) {
                    opcionValida = true; // Cambia estado de opcionValida.
                } else {
                    System.out.println("\n** Introduce una opción válida! **\n");

                    System.out.println("----");

                    // Mostramos menú en caso de opción no válida.
                    System.out.print("""
                    1 - Calcular el PVP de cada tipo de matrícula.
                    2 - Aplicar oferta sobre el precio base (sin iva).
                    3 - Calcular importe total de matrículas realizadas (sin iva).
                    4 - Salir.
                    """);
                    System.out.println("----");
                }
            } while (!opcionValida);

            System.out.println("----");
            // Pide IVA, descuentos a aplicar o otros datos de entrada necesarios.
            switch (seleccionMenu) {
                case 1:
                    System.out.println("Introduce el % de IVA aplicable en cada caso: 4%, 10% o 21%");

                    for (i = 1; i < 4; i++) {
                        switch (i) {
                            case 1:
                                // IVA aplicable válido. -- 4 / 10 / 21 %
                                ivaValido = false; // reset
                                do {
                                    System.out.print("Fitness --> IVA Aplicable: ");
                                    ivaFitness = sc.nextInt();

                                    if (ivaFitness == 4 || ivaFitness == 10 || ivaFitness == 21) {
                                        ivaValido = true;
                                    } else {
                                        System.out.println("\nIntroduce un IVA válido!! \n");
                                    }

                                } while (!ivaValido);
                                break;
                            case 2:
                                ivaValido = false; // reset
                                do {
                                    System.out.print("Yoga --> IVA Aplicable: ");
                                    ivaYoga = sc.nextInt();

                                    if (ivaYoga == 4 || ivaYoga == 10 || ivaYoga == 21) {
                                        ivaValido = true;
                                    } else {
                                        System.out.println("\nIntroduce un IVA válido!! \n");
                                    }

                                } while (!ivaValido);
                                break;
                            case 3:
                                ivaValido = false; // reset
                                do {
                                    System.out.print("Musculación --> IVA Aplicable: ");
                                    ivaMusculacion = sc.nextInt();

                                    if (ivaMusculacion == 4 || ivaMusculacion == 10 || ivaMusculacion == 21) {
                                        ivaValido = true;
                                    } else {
                                        System.out.println("\nIntroduce un IVA válido!! \n");
                                    }

                                } while (!ivaValido);
                                break;
                            default:
                                System.out.print("Error inesperado");
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    // Seleccionamos sobre que opción aplicar el descuento.
                    do {
                        System.out.print("""
                        Selecciona sobre qué aplicar el descuento:
                        1 - Fitness.
                        2 - Yoga.
                        3 - Musculación.
                        ...
                        """);
                        seleccionMatricula = sc.nextInt();

                        if (seleccionMatricula >= 1 && seleccionMatricula <= 3) {
                            matriculaValida = true;

                            // Asignamos el nombreMatricula.
                            switch (seleccionMatricula) {
                                case 1:
                                    nombreMatricula = "Fitness";
                                    break;
                                case 2:
                                    nombreMatricula = "Yoga";
                                    break;
                                case 3:
                                    nombreMatricula = "Musculación";
                                    break;
                            }
                        } else {
                            System.out.println("Introduce una opción válida! 1 - 3");
                        }

                        System.out.println();

                    } while (!matriculaValida);

                    do {
                        System.out.print("Introduce un porcentaje válido de descuento a aplicar 0-50%: ");
                        porcentajeDescuento = sc.nextInt();

                        if (porcentajeDescuento >= 0 && porcentajeDescuento <= 50) {
                            porcentajeValido = true;
                        } else {
                            System.out.print("Ese porcentaje no es válido.");
                        }

                        System.out.println();

                    } while (!porcentajeValido);

                    break;
                case 3:
                    // -----------------------
                    // Calculo de número de matrículas.
                    // -----------------------
                    do {
                        System.out.print("Número de matrículas realizadas de fitness -> ");
                        cantidadFitness = sc.nextInt();

                        System.out.print("Número de matrículas realizadas de yoga -> ");
                        cantidadYoga = sc.nextInt();

                        System.out.print("Número de matrículas realizadas de musculación -> ");
                        cantidadMusculacion = sc.nextInt();

                        // Validamos input no negativo.
                        if (cantidadFitness < 0 || cantidadYoga < 0 || cantidadMusculacion < 0) {
                            cantidadValida = false;

                            System.out.println("----");
                            System.out.println("Número no válido.");
                            System.out.println("----");
                        } else {
                            cantidadValida = true;
                        }
                    } while (!cantidadValida);
                    break;
                case 4:
                    cerrarPrograma = true;
                    break;
                default:
                    System.out.print("Error inesperado.");
            }

            //----------------------------------------------
            //                 Procesamiento 
            //----------------------------------------------
            if (!cerrarPrograma) {
                switch (seleccionMenu) {
                    case 1:
                        // Calculo precio de venta al público. 
                        // PVP = precioBase + (precioBase * IVA /100).
                        pvpFitness = PRECIO_BASE_FITNESS + (PRECIO_BASE_FITNESS * ivaFitness / 100.0);
                        pvpYoga = PRECIO_BASE_YOGA + (PRECIO_BASE_YOGA * ivaYoga / 100.0);
                        pvpMusculacion = PRECIO_BASE_MUSCULACION + (PRECIO_BASE_MUSCULACION * ivaMusculacion / 100.0);
                        break;
                    case 2:
                        // Calculo precio con oferta.
                        // PVP = precioBase - (precioBase * descuento /100).
                        switch (seleccionMatricula) {
                            case 1:
                                pvpOferta = PRECIO_BASE_FITNESS - (PRECIO_BASE_FITNESS * porcentajeDescuento / 100.0);
                                break;
                            case 2:
                                pvpOferta = PRECIO_BASE_YOGA - (PRECIO_BASE_YOGA * porcentajeDescuento / 100.0);
                                break;
                            case 3:
                                pvpOferta = PRECIO_BASE_MUSCULACION - (PRECIO_BASE_MUSCULACION * porcentajeDescuento / 100.0);
                                break;
                            default:
                                System.out.print("Error al calcular precio con oferta.");
                        }
                        break;
                    case 3:
                        // Calculo importe total matrículas realizadas.
                        for (i = 1; i < 4; i++) {
                            switch (i) {
                                case 1:
                                    importeTotal = (PRECIO_BASE_FITNESS * cantidadFitness);
                                    break;
                                case 2:
                                    importeTotal = importeTotal + (PRECIO_BASE_YOGA * cantidadYoga);
                                    break;
                                case 3:
                                    importeTotal = importeTotal + (PRECIO_BASE_MUSCULACION * cantidadMusculacion);
                                    break;
                                default:
                                    System.out.print("Error inesperado");
                            }
                        }
                        break;
                    case 4:
                        break;
                    default:
                        System.out.print("Error inesperado.");
                }
            }

            //----------------------------------------------
            //              Salida de resultados 
            //----------------------------------------------
            // Hará print de los resultados según el valor de seleccionMenú.
            switch (seleccionMenu) {
                case 1:
                    System.out.println("PRECIO DE VENTA AL PÚBLICO CON IVA: ");
                    System.out.println("---");

                    System.out.printf("PVP matrícula de fitness: %.2f %s%n", pvpFitness, MONEDA);
                    System.out.printf("PVP matrícula de yoga: %.2f %s%n", pvpYoga, MONEDA);
                    System.out.printf("PVP matrícula de musculación: %.2f %s%n", pvpMusculacion, MONEDA);
                    break;
                case 2:
                    System.out.println("PRECIO DE VENTA AL PÚBLICO CON OFERTA: ");
                    System.out.println("---");

                    System.out.printf("PVP matrícula %s con %d%% de descuento: %.2f %s%n",
                            nombreMatricula, porcentajeDescuento, pvpOferta, MONEDA);
                    break;
                case 3:
                    System.out.printf("Importe total de matrículas realizadas: %.2f %s%n", importeTotal, MONEDA);
                    break;
                case 4:
                    break;
                default:
                    System.out.print("Error inesperado.");
            }

            if (seleccionMenu == 4) {
                cerrarPrograma = true;
            } else {
                sc.nextLine(); // Limpiamos buffer.

                do {
                    System.out.println("----");
                    System.out.print("¿Quiere realizar otra gestión?... si/no: ");
                    continuarGestion = sc.nextLine().trim();

                    if (continuarGestion.equalsIgnoreCase("si")) {
                        seguirGestiones = true;
                        cerrarPrograma = false;
                    } else if (continuarGestion.equalsIgnoreCase("no")) {
                        seguirGestiones = true;
                        cerrarPrograma = true;
                    } else {
                        System.out.println("Introduce una respuesta válida...");
                        seguirGestiones = false;
                    }

                } while (!seguirGestiones);
            }

        } while (!cerrarPrograma);
        System.out.println("Programa finalizado.");
        sc.close(); // Cierre de Scanner.

    }
}
