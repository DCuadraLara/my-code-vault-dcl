/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadoresdeasignacion02;

/**
 * A book with 2 colors:red and green pages.
 * The program calculates how many red and green pages there are, based on number of pages.
 * The pattern always start on red followed by green.
 * @author David
 */

import java.util.Scanner;


public class OperadoresDeAsignacion02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Input
         Scanner scanner=new Scanner(System.in);
         System.out.print("Introduce the numbers of pages: ");
         int numberPages=scanner.nextInt();
         scanner.close();
         
         // Main
         int totalRed = numberPages / 2 + (numberPages % 2);
         int totalGreen = (numberPages / 2);
         
         // Output
         System.out.println("The total number of Red pages: " + totalRed + " and Green pages: " + totalGreen);
    }
}
