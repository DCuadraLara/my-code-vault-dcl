/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosresueltos04;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjerciciosResueltos04 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Init parameters
        double volumenPiramide, baseArea, altura, lado = 0;
        
        Scanner sc = new Scanner(System.in); // Init Scanner
        
        // Introducing values
        System.out.println("----------------------");
        System.out.println(" Calculador de Volumen de una piramide");
        System.out.println("----------------------\n");
        
        System.out.print("Introduce la longitud del lado de la base(metros): ");
        lado = sc.nextDouble();
        System.out.print("Introduce la altura(metros): ");
        altura = sc.nextDouble();
        sc.close();
        
        // Calculating area
        baseArea = lado * lado;
        volumenPiramide = (1.0/3.0) * baseArea * altura;
        
        // Calculating number of swimming pools
        double numPiscinas = volumenPiramide / 2500;
        
        // Output
        System.out.printf("El volumen de nuestra piramide es: %.2f metros cubicos%n", volumenPiramide);
        System.out.printf("Numero total de piscinas olimpicas: %.2f%n", numPiscinas);
    }
    
}
