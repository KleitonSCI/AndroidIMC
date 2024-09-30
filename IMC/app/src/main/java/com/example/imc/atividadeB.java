package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class atividadeB extends AppCompatActivity {
    float weight,height;
    public Float total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_b);
        TextView peso = findViewById(R.id.lblPeso);
        TextView altura = findViewById(R.id.lblAltura);
        TextView imc = findViewById(R.id.lblIMC);
        TextView resultado = findViewById(R.id.lblResultado);

        weight = getIntent().getExtras().getFloat("peso");
        height = getIntent().getExtras().getFloat("altura");
        total = weight/(height*height);
        System.out.println(weight);
        System.out.println(height);
        System.out.println(total);

        DecimalFormat df = new DecimalFormat(("##,##"));
        altura.setText(String.format(String.valueOf(height),"%.2f")+" m");
        peso.setText(String.format(String.valueOf(weight),"%.2f")+" Kg");
        imc.setText(df.format(total));
        setPerfil(total);





    }
    public void setPerfil(Float imc){
        ImageView image = findViewById(R.id.imageView);
        TextView result = findViewById(R.id.lblResultado);
        if (imc<=18.5){
            result.setText("Abaixo do Peso");
            image.setImageResource(R.drawable.abaixopeso);
        }else{
            if(imc<=24.9){
                result.setText("Normal");
                image.setImageResource(R.drawable.normal);
            }
            else{
                if(imc<=29.9){
                    result.setText("Sobrepeso");
                    image.setImageResource(R.drawable.sobrepeso);
                }
                else{
                    if(imc<=34.9){
                        result.setText("Obesidade grau 1");
                        image.setImageResource(R.drawable.obesidade1);
                    }
                    else{
                        if(imc<=39.9){
                            result.setText("Obesidade grau 2");
                            image.setImageResource(R.drawable.obesidade2);
                        }
                        else{
                            if(imc>=40){
                                result.setText("Obesidade grau 3");
                                image.setImageResource(R.drawable.obesidade3);
                            }
                        }
                    }
                }
            }
        }
    }
}