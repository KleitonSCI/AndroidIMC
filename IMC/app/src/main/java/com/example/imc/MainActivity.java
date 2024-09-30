package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida","onCreate");
        Button button = findViewById(R.id.button);
        EditText a = findViewById(R.id.txtAltura);
        EditText p = findViewById(R.id.txtPeso);


        //Button button = findViewById(R.id.btnFechar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),atividadeB.class);
                //i.putExtra("msg","oi");
                float h = Float.parseFloat(a.getText().toString());
                float w = Float.parseFloat(p.getText().toString());
                i.putExtra("altura",h);
                i.putExtra("peso",w);

                startActivity(i);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.d("ciclo de vida", "onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d("ciclo de vida", "onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.d("ciclo de vida","onPause");
    }
}