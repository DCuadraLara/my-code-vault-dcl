package ejerciciocondicionalcompuesto02;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioCondicionalCompuesto02 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Entrada de datos
        String calificacionCualitativa; // Podrá resultar en APROBADO/SUSPENSO.
        double nota; // Necesitamos introducir una nota a evaluar.

        // Procesamiento
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la nota para saber el resultado: ");
        nota = sc.nextDouble();
        
        if (nota >= 5)
            calificacionCualitativa = "APROBADO";
        else
            calificacionCualitativa = "SUSPENSO";
        
        // Salida de resultados
        System.out.print(calificacionCualitativa);
    }
    
}
