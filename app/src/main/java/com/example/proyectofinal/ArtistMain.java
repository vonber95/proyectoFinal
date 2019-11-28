package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ArtistMain extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ArrayList<Artist> artists;


    public ArrayList<Artist>  getDataForListView()
    {
        Artist artist;
        ArrayList<Artist> artistList = new ArrayList<Artist>();

        artist = new Artist("Rafael", R.drawable.artista);
        artistList.add(artist);

        artist = new Artist("Leonardo", R.drawable.artista2);
        artistList.add(artist);

        artist = new Artist("Dante", R.drawable.artista3);
        artistList.add(artist);

        return artistList;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentra_main);


        ListView lvArtist = (ListView) findViewById(R.id.list);

        artists = getDataForListView();

        ArtistAdapter artistAdapter = new ArtistAdapter(getApplicationContext(), R.layout.activity_encuentra, artists);

        lvArtist.setAdapter((artistAdapter));
        lvArtist.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Artist artist =  (Artist) parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), artist.getNombre(), Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, Details.class);
        intent.putExtra("nombre", artist.getNombre());
        intent.putExtra("imagen", artist.getImagen());
        startActivity(intent);
    }

}
