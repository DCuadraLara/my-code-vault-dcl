package ejercicioacumulador01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioAcumulador01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int inicio;
        int fin;
        int suma = 0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número de inicio: ");
        inicio = sc.nextInt();
        System.out.print("Introduce un número de fin: ");
        fin = sc.nextInt();
        sc.close();
        
        if (inicio > fin){
            System.out.println("Error, números fuera de rango.");
            return;
        }
        
        while (inicio <= fin){
            if (inicio % 3 == 0){
                suma += inicio;
            }
            inicio++;
        }
        System.out.printf("La suma total es: %d%n", suma);
    }
    
}
