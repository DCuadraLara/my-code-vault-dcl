package tarea1;

import java.util.Scanner;

/**
 * Ejercicio 1. Cálculos de expresiones físicas/matemáticas.
 * 
 * El programa solicita al usuario los valores de entrada necesarios
 * para realizar las operaciones definidas en el enumerado.
 * 
 * Muestra los resultados obtenidos en pantalla.
 * 
 * @author Cuadra Lara, David
 */

// Definicion del enum que contiene los nombres de las expresiones a calcular.
enum TipoOperaciones {
    OPERACION, // (x + x / 4.0) / (6.0 - x / 2.0)
    FUERZA_PESO, // masa * GRAVEDAD
    NUMERO_VUELTAS, // frecuencia * tiempo
    AREA_CIRCULO // PI * (radio * radio)
};

public class Ejercicio1 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes.
        final double GRAVEDAD = 9.8;
        // Calculo de PI aproximado mediante la serie de Leibniz (5 términos).
        final double PI = 4 * (1.0 - 1.0 / 3.0 + 1.0 / 5.0 - 1.0 / 7.0 + 1.0 / 9.0); 
        
        // Variables de entrada.
        int x, masa, tiempo = 0;
        double radio, frecuencia = 0.0;
        
        
        // Variables de salida.
        double resultadoOperacion = 0.0;
        double fuerzaPeso = 0.0;
        int numeroVueltas = 0;
        double areaCirculo = 0.0;
        
        // Clase Scanner para petición de datos de entrada.
        Scanner sc = new Scanner(System.in);
      
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("*** CALCULO DE EXPRESIONES FISICAS/MATEMATICAS ***");
        System.out.println("----------------------");
        System.out.println(" ");
        
        System.out.print("Introduce el valor de x: ");
        x = sc.nextInt();
        System.out.print("Introduce el valor de la masa(kg): ");
        masa = sc.nextInt();
        System.out.print("Introduce el valor de la frecuencia(hz): ");
        frecuencia = sc.nextDouble();
        System.out.print("Introduce el valor de tiempo(segundos): ");
        tiempo = sc.nextInt();
        System.out.print("Introduce el radio del circulo: ");
        radio = sc.nextDouble();
        sc.close(); // Cerramos scanner.
        
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        resultadoOperacion = (x + x / 4.0) / (6.0 - x / 2.0); // Operación matemática.
        fuerzaPeso = masa * GRAVEDAD; // Fuerza peso.
        numeroVueltas = (int)(frecuencia * tiempo); // Número de vueltas completas truncadas.
        areaCirculo = PI * (radio * radio); // Área de un círculo.
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS");
        System.out.println("---------");

        System.out.println(TipoOperaciones.OPERACION + "= " + resultadoOperacion); // Output OPERACION.
        System.out.println(TipoOperaciones.FUERZA_PESO + "= " + fuerzaPeso); // Output FUERZA_PESO.
        System.out.println(TipoOperaciones.NUMERO_VUELTAS + "= " + numeroVueltas); // Output NUMERO_VUELTAS.
        System.out.println(TipoOperaciones.AREA_CIRCULO + "= " + areaCirculo); // Output AREA_CIRCULO.
        
        System.out.println();
        System.out.println("Fin del programa."); 
    }
}