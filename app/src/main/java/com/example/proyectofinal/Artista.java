package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Artista extends AppCompatActivity {

    ImageButton imgButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista);

        imgButton = (ImageButton) findViewById(R.id.imageB);

        imgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imgButton.setImageResource(R.drawable.ic_heart_full);
            }
        });
    }
}
