package ejerciciofor01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioFor01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int inicio, fin, i;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número de inicio: ");
        inicio = sc.nextInt();
        System.out.print("Introduce un número de fin: ");
        fin = sc.nextInt();
        sc.close();
        
        System.out.printf("Secuencia de números de %d hasta %d%n", inicio, fin);
        for (i = inicio; i<=fin; i++){
            System.out.print(i);
        }
        System.out.println();
    }
    
}
