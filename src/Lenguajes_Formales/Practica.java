package Lenguajes_Formales;

import java.util.Scanner;

/*
 * Created on 01/09/2017.
 */
public class Practica {
    public static void main(String[] args) {
        //VARIABLES
        Lenguaje lenguaje;
        boolean estado = true;
        Scanner scanner = new Scanner(System.in);
        //CICLOS
        System.out.println("Alfabeto + Lenguaje + [Cadena | 0 | 1]:"); //Con 0 se pide un nuevo alfabeto y lenguaje, con 1 se termina el programa
        do {

            //System.out.println("Alfabeto:");
            //Lectura de datos
            //Alfabeto
            String x1 = scanner.nextLine();
            //Lenguaje
            //  System.out.println("Lengueje:");
            String x2 = scanner.nextLine();
            //Se crea un nuevo lenguaje
            lenguaje = new Lenguaje(x1, x2, "");
            //Se checa el lenguaje con el alfabeto
            if (lenguaje.pertenece()) {
                //Si se entra aqui, entonces el lenguaje no concuerda
                break;
            }
            System.out.println("Alfabeto: {" + lenguaje.getAbc() + "}");
            System.out.println("Lenguaje: {" + lenguaje.getLenguajeString() + "}");
            //System.out.println("W:");
            while (true) {
                //W
                String x3 = scanner.nextLine();
                if (x3.equals("1")) {// System.out.println("¿Terminaste? 1(Si)");
                    estado = false;
                    break;
                } else if (x3.equals("0")) {
                    System.out.println();
                    break;
                } else {
                    //Se checa que el lenguaje coincida con W
                    lenguaje.setW(x3);
                    if (lenguaje.checar()) {
                        System.out.println("W:" + lenguaje.getW() + " es acapetada en L*:{" + lenguaje.getLenguajeString() + "}*");
                    } else {
                        System.out.println("W:" + lenguaje.getW() + " es rechazada en L*:{" + lenguaje.getLenguajeString() + "}*, " + "{" + lenguaje.getError() + "} no pertence a L");
                    }
                }
            }
        } while (estado);


    }

}
