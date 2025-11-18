/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciowhile02;

/**
 *
 * @author David
 */
public class EjercicioWhile02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int NUM = 7;
        int conteo = 1;
        int res = 0;
        
        System.out.println("-- TABLA DE MULTIPLICACION DE 7 --");
        
        while (conteo <= 20){
            res = NUM * conteo;
            System.out.println(NUM + " * " + conteo + " = " + res);
            conteo++;
        }
        System.out.println();
        
    }
    
}
