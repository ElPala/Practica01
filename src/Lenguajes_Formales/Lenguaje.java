package Lenguajes_Formales;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created on 01/09/2017.
 */
public class Lenguaje {

    private String lenguajeString; //Lenguaje en forma de String
    private String abc; //alfabeto
    private String w; //W a analizar
    private HashMap<Character, ArrayList<String>> lenguajeMap; //HasMap donde se guarda el lenguaje segun el caracter
    private String error;//En caso de que se genere un error, se guarda

    //Constructor de la clase:
    public Lenguaje(String abc, String lenguajeString, String W) {
        //Se asignan el Lenguaje
        setLenguajeString(lenguajeString);
        //Se asigna el alfabeto
        setAbc(abc);
        //Se asigna el W
        setW(W);
        //Se inicializa el error sin nada
        setError("");
        //Se asigna el HashMap con la funcion hashMap(String)
        setLenguajeMap(hashMap(getLenguajeString()));
    }

    public HashMap<Character, ArrayList<String>> getLenguajeMap() {
        return lenguajeMap;
    }

    public void setLenguajeMap(HashMap<Character, ArrayList<String>> lenguajeMap) {
        this.lenguajeMap = lenguajeMap;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLenguajeString() {
        return lenguajeString;
    }

    public void setLenguajeString(String lenguajeString) {
        this.lenguajeString = lenguajeString;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    //Se crea un HashMap con el Lenguaje
    public HashMap<Character, ArrayList<String>> hashMap(String Lenguaje) {
        HashMap<Character, ArrayList<String>> hashMap = new HashMap<>(); //Se crea el HashMap
        int whereX = 0;  //Puntero para saber en que parte del String estoy
        for (int x = 0; x < Lenguaje.length(); x++) { //Se itera el string
            if (Lenguaje.charAt(x) == ',') {
                //Si se detecta un "," se ejecuta
                if (hashMap.containsKey(Lenguaje.charAt(whereX))) {
                    //El caracter esta contenido en el HashMap
                    hashMap.get(Lenguaje.charAt(whereX)).add(Lenguaje.substring(whereX, x)); //Se añade el substring
                } else {
                    //Se crea un nuevo ArrayList con el substring y se le añade al HasMap
                    ArrayList<String> newArrayList = new ArrayList<String>();
                    newArrayList.add(Lenguaje.substring(whereX, x));
                    hashMap.put(Lenguaje.charAt(whereX), newArrayList);
                }
                whereX = x + 1; //Se actualisa el puntero;
            } else if (x == Lenguaje.length() - 1) {
                //Caso especial para el ultimo substring
                if (hashMap.containsKey(Lenguaje.charAt(whereX))) {
                    hashMap.get(Lenguaje.charAt(whereX)).add(Lenguaje.substring(whereX, x + 1));
                } else {
                    ArrayList<String> newArrayList = new ArrayList<String>();
                    newArrayList.add(Lenguaje.substring(whereX, x + 1));
                    hashMap.put(Lenguaje.charAt(whereX), newArrayList);
                }
            }
        }

        for (Character x : hashMap.keySet()) {
            hashMap.get(x).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() < o2.length() ? 1 : -1;
                }
            });
        }

        return hashMap;
    }

    //Checa si el Lenguaje pertenece al alfabeto
    public boolean pertenece() {
        getLenguajeMap().put('f', null);
        for (int x = 0; x < getLenguajeString().length(); x++) { //Se itera el string y se compara con el lenguaje
            for (int y = 0; y <= getAbc().length(); y = y + 2) { //Se va iterando de dos en dos, puesto que el lenguaje esta dado a,b,c...
                if (getLenguajeString().charAt(x) == ',' || getLenguajeString().charAt(x) == getAbc().charAt(y)) {
                    //Se ingnoran las "," y si se encuentra W[x] en alfabeto[y], se deja de buscar.
                    break;
                } else if (y == getAbc().length() - 1) { //Si se llega al TOPE del alfabeto, entonces W[x]  no existe en el alfabeto.
                    System.out.println("El alfabeto no concuerda con L, " + getLenguajeString().charAt(x) + " no pertence al alfabeto:{" + getAbc() + "}");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checar() {
        int p1 = 0; //Para saber en donde estoy, INICIO del String
        int p2 = getW().length();//TOPE del string
        while (true) {//Siempre se repetira, para saber si esta bien escrito
            if (p1 == p2) { //Si p1 = p2 se completo la busqueda y por lo tanto esta bien escrito
                break;
            } else if (getLenguajeMap().containsKey(getW().charAt(p1))) {      //Se checa si existe el  caracter de W[p1] como llave del HashMap
                /*
                    Ejemplo:
                            p1=0
                            W:HOLA
                            W[0]=H
                            HashMap['H'] = ["HOLA", "HOTEL", "HOHOHO"] = TRUE
                 */
                ArrayList<String> arrayP1 = getLenguajeMap().get(getW().charAt(p1)); //S

                for (String x : arrayP1) {  //Ciclo para saber si hay coincidencias  en W
                    if ((p2 - p1) >= x.length() && x.equals(getW().substring(p1, p1 + x.length()))) { //Checa si hay espaio en W[p1:p1] y si es igual, se encontro en el leguaje
                        p1 += x.length(); //Se modifica el puntero p1 para acualizar en que parte de W estoy
                        break; //Se rompe el ciclo.
                    } else if (x.equals(arrayP1.get(arrayP1.size() - 1))) { //Si se llego al ultimo elemento, entonces hay incongruencias en el lenguaje
                        setError(getW().substring(p1, p2)); //se manda el substring del error.
                        return false;
                    }
                }
            } else {
                //No existe la inicial del caracter en el lenguaje, por lo tanto hay incongruencias  en W
                setError(getW().substring(p1, p2)); //Se manda la cadena de texto que es erronea.
                return false;
            }

        }
        return true;
    }

}
