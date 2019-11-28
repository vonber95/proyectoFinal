package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    ImageButton imgButton;
    String nombre;
    int idImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista);

        TextView tvNombre = (TextView) findViewById(R.id.name_artist_detail);
        ImageView ivImage = (ImageView) findViewById(R.id.image_artist_detail);

        Intent intent = getIntent();

        if (intent.getExtras() != null){
            nombre = intent.getStringExtra("nombre");
            idImage = intent.getIntExtra("imagen", R.mipmap.ic_launcher);

            tvNombre.setText(nombre);
            ivImage.setImageResource(idImage);
        }








        imgButton = (ImageButton) findViewById(R.id.imageB);

        imgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imgButton.setImageResource(R.drawable.ic_heart_full);
            }
        });
    }
}
