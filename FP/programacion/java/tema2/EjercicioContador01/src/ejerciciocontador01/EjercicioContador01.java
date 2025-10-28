package ejerciciocontador01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioContador01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        int inicio;
        int fin;
        int numMultiplos = 0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el inicio: ");
        inicio = sc.nextInt();
        System.out.print("Introduce el fin: ");
        fin = sc.nextInt();
        
        System.out.print("Numeros multiplos de 3 son: ");
        
        while (inicio < fin){
            if (inicio % 3 == 0){
                numMultiplos++;
                System.out.print(inicio);
                
                if (inicio + 3 < fin) {
                    System.out.print(", ");
                }
            }
            inicio++;
        }
        System.out.printf("\nNúmero total de multiplos: %d%n", numMultiplos);
    }
    
}
