package ejerciciocondicionalanidado01;

import java.util.Scanner;

/**
 * Revisará la nota introducida en base a condicionales anidados.
 * Podrá ser: INSUFICIENTE / SUFICIENTE / BIEN / NOTABLE / SOBRESALIENTE.
 * @author David
 */
public class EjercicioCondicionalAnidado01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Entrada de datos
        double nota;
        String calificacion = "INSUFICIENTE"; // Inicializamos en INSUFICIENTE.
        
        // Procesamiento
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la nota para saber la calificacion final: ");
        nota = sc.nextDouble();
        sc.close();
        
        if (nota >= 5.0 && nota < 6.0)
            calificacion = "SUFICIENTE";
        else
            if (nota >= 6.0 && nota < 7.0)
                calificacion = "BIEN";
            else
                if (nota >= 7.0 && nota < 9.0)
                    calificacion = "NOTABLE";
                else
                    if (nota >= 9.0)
                        calificacion = "SOBRESALIENTE";
        
        // Salida de resultados
        System.out.println("-----------------");
        System.out.print("La calificacion es: " + calificacion + "\n\n");
        System.out.println("-----------------");
    }
    
}
