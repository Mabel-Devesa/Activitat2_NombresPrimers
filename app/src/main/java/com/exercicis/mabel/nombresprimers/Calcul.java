package com.exercicis.mabel.nombresprimers;

import java.util.ArrayList;

public class Calcul {



public static int calcular(int pos, ArrayList<Integer> numPrimer, ArrayList<Integer> posicion){
    int numPrim=0;
    boolean esta = false;

    /* Comprobar si se encuentra almacenado en el arrayList de posiciones */
    esta = posicion.contains(pos);
    if(esta){
        int index = posicion.indexOf(pos);
        numPrim = numPrimer.get(index);
    }

    /* En el caso de que no se encuentre en el arrayList, lo calcula y posteriormente lo guarda en los 2 ArrayLists */
    else if(!esta){
        int num=1;
        int numDiv;
        int contPos=0;
        while(contPos < pos){
            numDiv=2;
            boolean primo=true;
            while(numDiv<num && primo){
                if(num%numDiv == 0) {
                    primo=false;
                }
                else {
                    numDiv++;
                }
            }
            if(primo){
                contPos++;
                if(contPos == pos){
                    posicion.add(pos);
                    numPrimer.add(num);
                    numPrim = num;

                }
            }
            num++;
        }
    }

    return numPrim;
}
}
