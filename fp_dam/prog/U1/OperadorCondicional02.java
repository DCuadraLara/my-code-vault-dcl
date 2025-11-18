/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadorcondicional02;


import java.util.Scanner;
        
/**
 * It's a calculator of ODD or EVEN numbers based on (condition ?: x : y).
 * User must introduce a number to show the result.
 * @author David
 */
public class OperadorCondicional02 {

    /**
     * 
     * @param args the command line arguments (args unused)
     */
    public static void main(String[] args) {
        // Ask the user a number
         Scanner sc=new Scanner(System.in); // Init Scanner
         System.out.println("*** Welcome to our even and odd number calculator ***\n");
         System.out.println("Introduce a number please: ");
         int number=sc.nextInt();
         sc.close(); // Close Scanner
         
         // Check with condition and print Even / Odd
         System.out.print("The number is: ");
         System.out.println((number % 2 == 0) ? "Even" : "Odd");
    }
    
}
