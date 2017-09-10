package Lenguajes_Formales;

import javax.swing.text.html.HTML;
import java.util.*;

/**
 * Created by Palafd  on 01/09/2017.
 */
public class Lenguaje {
    private String lenguajeString;
    private String abc;
    private String w;
    private HashMap<Character,ArrayList<String>> lenguajeMap;
    private String error;

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

    public Lenguaje(String abc, String lenguajeString, String W) {
        setLenguajeString(lenguajeString);
        setAbc(abc);
        setW(W);
        setError("");
        setLenguajeMap(hashMap(getLenguajeString()));
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

    private static HashMap<Character,ArrayList<String>> hashMap(String Lenguaje){
        HashMap<Character, ArrayList<String>> hashMap =  new HashMap<>();
        int whereX=0;
        for(int x=0;x<Lenguaje.length();x++){
            if (Lenguaje.charAt(x)==','){
                if(hashMap.containsKey(Lenguaje.charAt(whereX))){
                        hashMap.get(Lenguaje.charAt(whereX)).add(Lenguaje.substring(whereX,x));
                }else{
                    ArrayList<String> newArrayList =  new ArrayList<String>();
                    newArrayList.add(Lenguaje.substring(whereX,x));
                    hashMap.put(Lenguaje.charAt(whereX), newArrayList);
                }
                whereX = x+1;
            }else if (x==Lenguaje.length()-1){
                if(hashMap.containsKey(Lenguaje.charAt(whereX))){
                    hashMap.get(Lenguaje.charAt(whereX)).add(Lenguaje.substring(whereX,x+1));
                }else{
                    ArrayList<String> newArrayList =  new ArrayList<String>();
                    newArrayList.add(Lenguaje.substring(whereX,x+1));
                    hashMap.put(Lenguaje.charAt(whereX), newArrayList);
                }
            }
        }

        for(Character x : hashMap.keySet()){
            hashMap.get(x).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length()< o2.length() ? 1:-1;
                }
            });
        }

        return hashMap;
    }

    public  boolean pertenece (){
        boolean estado=true;
        for(int x=0;x<getLenguajeString().length();x++){
            for(int y=0; y<=getAbc().length(); y=y+2){
                if(getLenguajeString().charAt(x)== ','){
                    break;
                }else if(getLenguajeString().charAt(x)== getAbc().charAt(y)){
                    estado=true;
                    break;
                }else{
                    estado=false;
                }
            }
            if (estado==false){
                System.out.println("El alfabeto no concuerda con L, "+getLenguajeString().charAt(x)+" no pertence al alfabeto:{"+getAbc()+"}");
                return true;
            }
        }
        return false;
    }


    public  boolean checar(){
        int p1=0;
        int p2=getW().length();
        while (true){
            if(p1==p2){
                break;
            }else if(getLenguajeMap().containsKey(getW().charAt(p1))){
                for(String x: getLenguajeMap().get(getW().charAt(p1))){
                    if((p2-p1)>=x.length() && x.equals(getW().substring(p1,p1+x.length()))){
                        p1+=x.length();
                        break;
                    }else if (x.equals(getLenguajeMap().get(getW().charAt(p1)).get(getLenguajeMap().get(getW().charAt(p1)).size()-1))){
                        setError(getW().substring(p1,p2));
                        return false;
                    }
                }
            }
            else {
                setError(getW().substring(p1,p2));
                return false;
            }

        }
        return true;
    }

}
