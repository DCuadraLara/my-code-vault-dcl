package ejerciciometodoestático02;

import java.util.Random;

/**
 *
 * @author David
 */
public class EjercicioMetodoEstático02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Generar num aleatorio 10 - 20.
        Random num1 = new Random(); // construimos objeto
        int number = num1.nextInt(10, 21);
        
        System.out.println(number);
    }
    
}
