package ejercicioestructuraswitch02;

/**
 *
 * @author David
 */
public class EjercicioEstructuraSwitch02 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        //-----------------------------------------
        //          Declaración de variables
        //-----------------------------------------
        double nota = 0;
        int nota_num = 0;
        String calificacion = "";
        final int PREGUNTASACERTADAS = 17;
        final int PREGUNTASFALLADAS = 3;

        //-----------------------------------------
        //          Procesamiento
        //-----------------------------------------
        nota = PREGUNTASACERTADAS * 0.5 - PREGUNTASFALLADAS * 0.25;
        nota = nota_num;
        
        switch(nota_num){
            case 0: case 1: case 2: case 3: case 4:
                calificacion = "SUSPENSO";
                break;
            case 5:
                calificacion = "SUFICIENTE";
                break;
            case 6:
                calificacion = "BIEN";
                break;
            case 7: case 8:
                calificacion = "NOTABLE";
                break;
            case 9: case 10:
                calificacion = "SOBRESALIENTE";
                break;
            default:
                calificacion = "Nota no valida";  
        }
        
        //-----------------------------------------
        //          Salida de resultados
        //-----------------------------------------
        System.out.printf("El resultado es: %s%n", calificacion);
    }
    
}
