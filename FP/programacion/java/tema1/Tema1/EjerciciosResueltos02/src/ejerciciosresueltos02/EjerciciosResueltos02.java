/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosresueltos02;

import java.util.Scanner;


/**
 * 
 * @author David
 */
public class EjerciciosResueltos02 {

    /**
     * @param args the command line arguments(unused)
     */
    public static void main(String[] args) {
        // Init parameters
        double totalNum = 0;
        
        // Introduce menu
        System.out.println("---------------------");
        System.out.println("Calculos Aritmeticos ");
        System.out.println("---------------------\n");
        
        // Ask for the numbers
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce dos numeros reales: ");
        
        System.out.print("Primer numero: ");
        double primerNum = sc.nextDouble();
        System. out.print("Segundo numero: ");
        double segundoNum = sc.nextDouble();
        
        // Math calculations
        totalNum = primerNum * 2;
        System.out.println("El doble del primer numero es: " + totalNum);
        totalNum = segundoNum / 2;
        System.out.println("La mitad del segundo numero es:  " + totalNum);
        totalNum = primerNum + segundoNum * primerNum + segundoNum;
        System.out.println("El cuadrado de la suma de ambos numeros: " + totalNum);
        totalNum = (primerNum * primerNum + segundoNum * segundoNum) / 10;
        System.out.println("La decima parte de la suma de los cuadrados de ambos numeros: " + totalNum);
    }
    
}
