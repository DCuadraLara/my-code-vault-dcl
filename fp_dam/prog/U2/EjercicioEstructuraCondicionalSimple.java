package ejercicioestructuracondicionalsimple;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioEstructuraCondicionalSimple {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.print("Introduzca un número entero: ");
        numero = teclado.nextInt();
        
        if (numero % 2 == 0)
            System.out.println("El número es par");
        else
            System.out.println("El número es impar");
    }
    
}
