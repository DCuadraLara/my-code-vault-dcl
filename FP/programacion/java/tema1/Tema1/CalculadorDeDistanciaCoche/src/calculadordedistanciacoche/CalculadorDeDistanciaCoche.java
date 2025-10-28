/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadordedistanciacoche;

/**
 * We need to calculate the distance we already did on kilometers and meters.
 * This program calculates the traveled distance based on speed(km/h) and time(s).
 * @author David
 */

import java.util.Scanner;


public class CalculadorDeDistanciaCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      Scanner scanner=new Scanner(System.in);
      System.out.print("Velocidad en kilometros por hora:");
      double velocidad=scanner.nextDouble();
      System.out.print("Tiempo en segundos:");
      int segundos=scanner.nextInt();
      scanner.close();
      
      // Calculos
      double kilometrosPorSegundo = velocidad / 3600;
      
      // Salida de datos
      System.out.println("Distancia recorrida en kilometros: " + (kilometrosPorSegundo * segundos));
      System.out.println("Distancia recorrida en metros: " + (kilometrosPorSegundo * segundos) * 1000);
      
    }
}
