package ejerciciodowhile02;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioDoWhile02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Introduce un numero par valido: ");
            num = sc.nextInt();
        }
        while (num % 2 != 0);
        sc.close();
    }
    
}
