/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosresueltos01;

/**
 *
 * @author David
 */
public class EjerciciosResueltos01 {

    /**
     * Define un enumerado con la expresion enum, mostrando los palos de la baraja española.
     * Nos mostrará OROS, COPAS, BASTOS, ESPADAS.
     * @param args the command line arguments (unused)
     */
    
    
    // Init enum
    public enum PalosBarajaEspañola {
        OROS,
        COPAS,
        BASTOS,
        ESPADAS
    };
    
    
    public static void main(String[] args) {
        // Menu
        System.out.println("-----------------------------");
        System.out.println(" PALOS DE LA BARAJA ESPAÑOLA ");
        System.out.println("-----------------------------");
        
        // Assignment
        PalosBarajaEspañola primerPalo = PalosBarajaEspañola.OROS ;
        PalosBarajaEspañola segundoPalo = PalosBarajaEspañola.COPAS ;
        PalosBarajaEspañola tercerPalo = PalosBarajaEspañola.BASTOS ;
        PalosBarajaEspañola cuartoPalo = PalosBarajaEspañola.ESPADAS ;
        
        // Output
        System.out.println("Palo 1: " + primerPalo);
        System.out.println("Palo 2: " + segundoPalo);
        System.out.println("Palo 3: " + tercerPalo);
        System.out.println("Palo 4: " + cuartoPalo);
        
    }
    
}
