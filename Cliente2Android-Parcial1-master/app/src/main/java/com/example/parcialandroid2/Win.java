package com.example.parcialandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Win extends AppCompatActivity {

    ImageButton againBtn1;
    ImageButton exitBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        againBtn1 = findViewById(R.id.againBtn1);
        exitBtn2 = findViewById(R.id.exitBtn2);

        //Cambio de actividad
        againBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Win.this,MainActivity2.class ));

            }});


        //Cerrar la app
        exitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}