package com.exercicis.mabel.nombresprimers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button boton;
    TextView aviso;
    EditText valorPosicion;
    TextView resultado;

    ArrayList<Integer> numPrimer = new ArrayList<>();
    ArrayList<Integer> posicion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Asociar los elementos en Java */
        boton = findViewById(R.id.boton);
        aviso = findViewById(R.id.textAvis);
        valorPosicion = findViewById(R.id.posicio);
        resultado =  findViewById(R.id.resultado);



        boton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    /* Comprobacion si el valor introducido cumple las condiciones */
                    String valorS = valorPosicion.getText().toString();
                    boolean cumple =false;
                    int valorInt=0;
                    try{
                        valorInt = Integer.parseInt(valorS);
                        if(valorInt >0) {
                            int digitos = Integer.toString(valorInt).length();
                            if (digitos <= 6) {
                                cumple = true;
                            }
                            else{
                                aviso.setVisibility(View.VISIBLE);
                            }
                        }
                        else{
                            aviso.setVisibility(View.VISIBLE);
                        }
                    }catch(NumberFormatException e){
                        aviso.setVisibility(View.VISIBLE);
                    }
                    if(cumple){
                        /* Si cumple las condiciones, avisa al metodo calcular de la clase calcul y pasar como a parametro la posicion y los dos ArrayList */
                        int numP = Calcul.calcular(valorInt, numPrimer, posicion);

                        /* Mostrar resultado */

                        String resultadoStr=getString(R.string.result1)+" "+String.valueOf(valorInt) +" "+getString(R.string.result2)+" "+String.valueOf(numP);

                        resultado.setText(resultadoStr);
                    }
                }
        });



    }
}
