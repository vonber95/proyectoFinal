package com.example.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    private ArrayList<Artist>  artists;

    public ArtistAdapter (Context context, int textViewResourceId, ArrayList<Artist> objects){

        super(context, textViewResourceId, objects);
        this.artists = objects;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent){


        View v = convertView;

        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_encuentra, null);
        }


        Artist artista = artists.get(position);

        if (artista != null){
            TextView tvNombre = (TextView) v.findViewById(R.id.nombre_artista);
            ImageView ivImage = (ImageView ) v.findViewById(R.id.imagen_artista);


            tvNombre.setText(artista.getNombre());
            ivImage.setImageResource(artista.getImagen());
        }
        return v;
    }
}
