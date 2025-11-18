package tarea1;

import java.util.Scanner;

/**
 * Ejercicio 2. Uso de cadenas.
 * 
 * El programa solicita al usuario una letra.
 * Se transformará el string inicial basado en varios puntos dados en el ejercicio.
 * 
 * @author Cuadra Lara, David
 */

public class Ejercicio2 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables constantes.
        final String FRASE_INICIAL = "  Don Quijote de la Mancha  ";
        
        // Variables de entrada.
        String letraStr = "";
        
        // Variables de salida.
        int longitudCadena = 0;
        char caracterCentral = 'a';
        String nuevaCadena = "";
        
        // Clase Scanner para petición de datos de entrada
        Scanner sc = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2. Uso de cadenas ");
        System.out.println("----------------------");
        System.out.println(" ");
        
        System.out.print("Introduzca la letra del grupo al que perteneces: ");
        letraStr = sc.next();
        letraStr = letraStr.toUpperCase(); // Convertir a mayúsculas.
        System.out.println("Cadena original: " + FRASE_INICIAL);

        sc.close();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // 1. Eliminar espacios.
        nuevaCadena = FRASE_INICIAL.trim();

        // 2. Eliminar "Don Quijote".
        nuevaCadena = nuevaCadena.replace("Don Quijote", "").trim();

        // 3. Sustituir 'M' por 'L'.
        nuevaCadena = nuevaCadena.replace('M', 'L');
        
        // 4. Añadir guión + letra.
        char letra = letraStr.charAt(0);
        nuevaCadena = nuevaCadena.concat("-" + letra);
        
        // 5. Calcular longitud.
        longitudCadena = nuevaCadena.length();
        
        // 6. Obtener carácter central.
        caracterCentral = nuevaCadena.charAt(longitudCadena / 2);
        
        // 7. ¿Contiene 'M'? - SI / NO.
        boolean contieneM = nuevaCadena.contains("M");
        
        //8. ¿Termina en consonante? - SI / NO.
        boolean consonante = letra != 'A' &&
                             letra != 'E' &&
                             letra != 'I' &&
                             letra != 'O' &&
                             letra != 'U';
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        System.out.println("La cadena final es: " + nuevaCadena);
        System.out.println("Contiene: " + longitudCadena + " caracteres");
        System.out.println("Tiene el caracter: '" + caracterCentral + "' en su posicion central");
        System.out.println("Contiene el caracter 'M': " + contieneM);
        System.out.println("Termina en consonante: " + consonante);
        
        System.out.println();
        System.out.println("Fin del programa.");  
    }
}