/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosresueltos05;

import java.util.Scanner;


/**
 * Checks the relation conditionals to know if they are True or False.
 * @author David
 */
public class EjerciciosResueltos05 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Intro Menu
        System.out.println("*** Welcome to our number check program *** ");
        System.out.println("-------------------------------");
        Scanner sc = new Scanner(System.in); // Init Scanner
        
        // Input variables
        System.out.print("Introduce a number: ");
        int numEntero = sc.nextInt();
        sc.close();
        
        // Output
        System.out.println(numEntero == 0); // si es cero
        System.out.println(numEntero > 0); // si es positivo
        System.out.println(numEntero < 100); // si es menor que cien
        System.out.println((numEntero % 2) == 0); // si es par
        
    }
    
}
