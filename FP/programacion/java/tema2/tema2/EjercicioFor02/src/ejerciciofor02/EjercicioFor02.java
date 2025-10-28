package ejerciciofor02;

/**
 *
 * @author David
 */
public class EjercicioFor02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, total;
        final int NUM = 7;
        
        System.out.print("-- TABLA DE MULTIPLICAR DE 7 --\n");
        for(i = 1; i <= 10; i++){
            total = i * NUM;
            System.out.printf("%d * %d = %d%n", NUM, i, total);
        }
    }
    
}
