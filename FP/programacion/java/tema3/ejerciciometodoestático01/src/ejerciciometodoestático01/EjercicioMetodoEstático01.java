package ejerciciometodoestático01;

import java.util.Random;
        
/**
 *
 * @author David
 */
public class EjercicioMetodoEstático01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double num = 1 + Math.random()*10;
        
        Random number = new Random();
        int numero = number.nextInt(10) + 1;
        
        System.out.println(num);
        System.out.println(numero);
    }
    
}
