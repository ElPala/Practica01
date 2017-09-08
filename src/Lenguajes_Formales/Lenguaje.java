package Lenguajes_Formales;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Palafox on 01/09/2017.
 */
public class Lenguaje {
    private String lenguajeString;
    private String abc;
    private String w;
    private ArrayList<String> lenguajeArray;
    private String error;

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
        setLenguajeArray(arrayLengueje(getLenguajeString()));
    }

    public String getLenguajeString() {
        return lenguajeString;
    }

    public void setLenguajeString(String lenguajeString) {
        this.lenguajeString = lenguajeString;
    }

    public ArrayList<String> getLenguajeArray() {
        return lenguajeArray;
    }

    public void setLenguajeArray(ArrayList<String> lenguajeArray) {
        this.lenguajeArray = lenguajeArray;
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

    private   ArrayList<String> arrayLengueje(String Lenguaje){
        ArrayList<String> arrayList = new ArrayList<>();
        int whereX=0;
        for(int x=0;x<Lenguaje.length();x++){
            if (Lenguaje.charAt(x)==','){
                arrayList.add(Lenguaje.substring(whereX,x));
                whereX = x+1;
            }else if(x==Lenguaje.length()-1){
                arrayList.add(Lenguaje.substring(whereX));
            }
        }
        return arrayList;
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

    public boolean contiene(String subW){
        return getLenguajeArray().contains(subW);
    }

    public boolean checar(){
        int p1=0;
        int p2=getW().length();
        while (true){
            for(int x=0; x<getLenguajeArray().size();x++){
                if((p2-p1)>=getLenguajeArray().get(x).length() && contiene(getW().substring(p1,p1+getLenguajeArray().get(x).length()))){
                        p1+=getLenguajeArray().get(x).length();
                        break;
                }else if(x==getLenguajeArray().size()-1){
                    setError(getW().substring(p1,p2));
                    return false;
                }
            }
            if(p1==p2){
                      break;
            }

        }
        return true;
    }

    public  void acomodo(){
        getLenguajeArray().sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()< o2.length() ? 1:-1;
            }
        });
    }
}
