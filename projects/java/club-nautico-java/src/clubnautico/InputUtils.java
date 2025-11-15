package clubnautico;

import java.util.Scanner;

/**
 * <p>
 * Clase de utilidades para la entrada de datos por consola. Proporciona métodos
 * estáticos que permiten solicitar valores validados al usuario, evitando
 * repetir la misma lógica de comprobación en diferentes partes del programa.
 * </p>
 *
 * <p>
 * Incluye validaciones para:
 * </p>
 * <ul>
 * <li>Números enteros positivos</li>
 * <li>Números decimales positivos</li>
 * <li>Cadenas de texto no vacías</li>
 * </ul>
 *
 * <p>
 * Su uso centraliza la lógica de lectura y validación, mejorando la claridad,
 * reutilización y mantenimiento del código del proyecto.
 * </p>
 *
 * @author David Cuadra Lara
 * @version 1.0
 */
public class InputUtils {

    // Método generico para ahorrar código.
    public static String pedirStringNoVacio(Scanner sc, String mensaje) {
        boolean datosValidos = false;
        String inputStr = "";

        while (!datosValidos) {
            System.out.printf("%s : ", mensaje);
            inputStr = sc.nextLine().trim();

            if (inputStr.trim().isEmpty()) {
                System.err.println("Error: campo vacío.");
            } else {
                datosValidos = true;
            }
        }

        return inputStr;
    }

    public static int pedirEnteroPositivo(Scanner sc, String mensaje) {
        boolean datosValidos = false;
        int numInput = 0;

        while (!datosValidos) {
            try {
                System.out.printf("%s: ", mensaje);
                numInput = sc.nextInt();

                if (numInput < 0) {
                    System.err.println("Error: número negativo o 0.");
                } else {
                    datosValidos = true;
                }
            } catch (Exception e) {
                System.err.println("Error: número no válido");
            } finally {
                sc.nextLine();
            }
        }
        return numInput;
    }

    public static double pedirDoublePositivo(Scanner sc, String mensaje) {
        boolean datosValidos = false;
        double numInput = 0;

        while (!datosValidos) {
            try {
                System.out.printf("%s: ", mensaje);
                numInput = sc.nextDouble();

                if (numInput <= 0) {
                    System.err.println("Error: introduce un número mayor que 0.");
                } else {
                    datosValidos = true;
                }

            } catch (Exception e) {
                System.err.println("Error: introduce un número decimal válido.");
            } finally {
                sc.nextLine();
            }
        }

        return numInput;
    }

    public static boolean pedirBoolean(Scanner sc, String mensaje) {
        String input = "";
        boolean datosValidos = false;

        while (!datosValidos) {
            System.out.printf("%s (SI/NO): ", mensaje);
            input = sc.nextLine().trim().toUpperCase();

            switch (input) {
                case "SI":
                    return true;
                case "NO":
                    return false;
                default:
                    System.err.println("Error: introduce 'SI' o 'NO'.");
                    break;
            }
        }

        return false;
    }

}
