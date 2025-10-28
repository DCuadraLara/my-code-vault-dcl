/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajocadenas02;

import java.util.Scanner;


/**
 * Asks a word to the user and then print the first and last letters.
 * @author David
 */
public class TrabajoCadenas02 {

    /**
     * @param args the command line arguments(unused)
     */
    public static void main(String[] args) {
        // Init parameters
        int numPalabras = 0;
        char letraActual = 'x';
        
        // We read the user word
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduzca una palabra: ");
        String palabra= teclado.nextLine();
        System.out.println("La palabra introducida es " + palabra);
        
        // Check lenght
        numPalabras = palabra.length();
        
        // Get first and last letters
        System.out.println("---- Scanning word ----");
        
        letraActual = palabra.charAt (0);
        System.out.println("La primera letra es: " + letraActual);
        letraActual = palabra.charAt(numPalabras - 1);
        System.out.println("La ultima letra es: " + letraActual);
    }
    
}
