package ejerciciowhile01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioWhile01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int inicio;
        int fin;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el inicio en numero: ");
        inicio = sc.nextInt();
        System.out.print("Introduce el fin en numero: ");
        fin = sc.nextInt();
        sc.close();
        
        while (inicio <= fin){
            System.out.print(" " + inicio);
            inicio++;
        }
        System.out.println();
    }
    
}
