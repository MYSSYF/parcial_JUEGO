package com.example.parcialandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Lose extends AppCompatActivity {

    ImageButton exitBtn1;
    ImageButton againBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        exitBtn1 = findViewById(R.id.exitBtn1);
        againBtn = findViewById(R.id.againBtn);

        //Cambio de actividad
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lose.this,MainActivity2.class ));

        }});


        //Cerrar la app
        exitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}