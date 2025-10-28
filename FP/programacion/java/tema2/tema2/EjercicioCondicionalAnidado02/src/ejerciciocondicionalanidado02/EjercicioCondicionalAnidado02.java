package ejerciciocondicionalanidado02;

import java.util.Scanner;

/**
 * Calcula la nota de un examen tipo test de 20 preguntas.
 * Cada acierto suma 0.5; cada fallo resta 0.25
 * @author David
 */
public class EjercicioCondicionalAnidado02 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        //-----------------------------------------
        //          Declaración de variables
        //-----------------------------------------
        String calificacion = "SUSPENSO"; // Valor por defecto.
        int numeroAcertadas;
        int numeroFalladas;
        final int PREGUNTASTOTAL = 20;
        double nota = 0.0;
        
        Scanner sc = new Scanner(System.in); //init Scanner.
        
        //-----------------------------------------
        //          Entrada de datos
        //-----------------------------------------
        System.out.print("Introduce número de preguntas acertadas: ");
        numeroAcertadas = sc.nextInt();
        System.out.print("Introduce número de preguntas falladas: ");
        numeroFalladas = sc.nextInt();
        sc.close();
        
        //-----------------------------------------
        //          Procesamiento
        //-----------------------------------------
        // Check de número total de preguntas > 20.
        if (numeroAcertadas + numeroFalladas > PREGUNTASTOTAL)
            calificacion = "Datos erróneos";
        else if (numeroAcertadas < 0 || numeroAcertadas > PREGUNTASTOTAL)
            calificacion = "Datos erróneos";
        else if (numeroFalladas < 0 || numeroFalladas > PREGUNTASTOTAL)
            calificacion = "Datos erróneos";
        else{
            // Calculamos la nota.
            nota = 0.5 * numeroAcertadas - 0.25 * numeroFalladas;
            
            // Condicionales para asignarle una calificación.
            if (nota < 5.0)
                calificacion = "SUSPENSO";
            else if (nota < 6.0)
                calificacion = "SUFICIENTE";
            else if (nota < 7.0)
                calificacion = "BIEN";
            else if (nota < 9.0)
                calificacion = "NOTABLE";
            else
                calificacion = "SOBRESALIENTE";
        }
        
        //-----------------------------------------
        //          Salida de resultados
        //-----------------------------------------
        if (!calificacion.equals("Datos erróneos")){
            System.out.printf("La calificion numerica es: %.2f%n", nota);
            System.out.printf("La calificion no numerica es: %s%n", calificacion);
        }
        else
            System.out.println(calificacion);
    }
    
}
