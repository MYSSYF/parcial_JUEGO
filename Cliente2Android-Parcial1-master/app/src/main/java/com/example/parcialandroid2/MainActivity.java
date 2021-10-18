package com.example.parcialandroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton exitBtn;
    ImageButton playBtn;

    //Primer activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBtn = findViewById(R.id.exitBtn);
        playBtn = findViewById(R.id.playBtn);

        //Cambio de actividad
        playBtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           startActivity(new Intent(MainActivity.this,MainActivity2.class ));

                                       }
                                   }

        );

        //Cerrar la app
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}