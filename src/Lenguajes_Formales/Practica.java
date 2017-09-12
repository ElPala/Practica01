package Lenguajes_Formales;

import java.util.Scanner;

/*
 * Created on 01/09/2017.
 */
public class Practica {
    public static void main(String[] args) {
        //VARIABLES
        Lenguaje lenguaje;
        Scanner scanner = new Scanner(System.in);
        //CICLOS
        System.out.println("Abecedario|Lengueje|W:");
        do {
            //Lectura de datos
            //Abecedario
            String x1 = scanner.nextLine();
            //Lenguaje
            String x2 = scanner.nextLine();
            //W
            String x3 = scanner.nextLine();
            //Se crea un nuevo lenguaje
            lenguaje = new Lenguaje(x1, x2, x3);
            //Se checa el lenguaje con el abcedario
            if (lenguaje.pertenece()) {
                //Si se entra aqui, entonces el lenguaje no concuerda
                if (scanner.nextLine().equals("1")) {
                    //si se entra aqui, es que se acabo el programa
                    break;
                } else {
                    //se rebobina
                    continue;
                }
            }
            //Se checa que el lenguaje coincida con W
            if (lenguaje.checar()) {
                System.out.println("W:" + lenguaje.getW() + " es acapetada en L*:{" + lenguaje.getLenguajeString() + "}*");
            } else {
                System.out.println("W:" + lenguaje.getW() + " es rechazada en L*:{" + lenguaje.getLenguajeString() + "}*, " + "{" + lenguaje.getError() + "} no pertence a L");
            }
            // System.out.println("¿Terminaste? 1(Si)/ 0(NO)");
            if (scanner.nextLine().equals("1")) {
                break;
            }
        } while (true);


    }

}
