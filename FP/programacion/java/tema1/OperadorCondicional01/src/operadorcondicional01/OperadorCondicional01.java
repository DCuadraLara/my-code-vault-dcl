/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadorcondicional01;

/**
 * Generates a random number in [0, 100).
 * Check if the number is included in our conditions.
 * No if / else statements are used.
 * @author David
 */
public class OperadorCondicional01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Generates a random num x -> [0, 100)
        final double x=Math.random()*100;
        final String t = "True", f = "False";
        
        System.out.println("\nNuestro numero es: " + x + "\n");
        
        // randomNum in [0, 20)
        System.out.println("[0, 20) --> " + (x < 20 ? t : f));
        // randomNum in [20, 50]
        System.out.println("[20, 50] --> " + ((x >= 20 && x <= 50) ? t : f));
        // randomNum in (50, 75)
        System.out.println("(50, 75) --> " + ((x > 50 && x < 75) ? t : f));
        // randomNum in [75, 100)
        System.out.println("[75, 100) --> " + (x >= 75 ? t : f));
    }
    
}
