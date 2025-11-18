package ejerciciocondicionalcompuesto01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioCondicionalCompuesto01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println("Introduce un numero para saber si es positivo o negativo: ");
        numero = sc.nextInt();
        
        if (numero > 0)
            System.out.println("El numero es positivo ");
        else if (numero < 0)
            System.out.println("El numero es negativo ");
        else
            System.out.println("Es 0 ");
    }
    
}
