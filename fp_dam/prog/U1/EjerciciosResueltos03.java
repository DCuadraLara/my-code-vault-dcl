package ejerciciosresueltos03;

import java.util.Scanner;


/**
 *
 * @author David
 */
public class EjerciciosResueltos03 {

    /**
     * Transforma las longitudes dada en metros introducida a las dadas en el ejercicio.
     * @param args the command line arguments(unused)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Init scan
        System.out.println("*** Bienvenido al programa de transformacion de unidades ***");
        System.out.println("------------------------------------------------------------");
        
        // Input parameters
        System.out.print("Introduzca la longitud en metros que desea transformar: ");
        double longitudeM=sc.nextDouble();
        sc.close();
        
        // International SI
        System.out.println("SISTEMA INTERNACIONAL ");
        System.out.println("----------------------");
        
        double longitudeDm = longitudeM * 10;
        double longitudeCm = longitudeDm * 10;
        double longitudeMm = longitudeCm * 10;
        System.out.println(longitudeM + " M, " + longitudeDm + " dm, " + longitudeCm + " cm, " + longitudeMm + " mm.");
        
        // Anglosajon SI
        System.out.println("SISTEMA ANGLOSAJON ");
        System.out.println("----------------------");
        
        double pulgada = longitudeCm / 2.54;
        double pie = pulgada / 12;
        double yarda = pie / 3;
        System.out.println(pulgada + " Pulgadas, " + pie + " Pie, " + yarda + " Yarda.");
    }
    
}
