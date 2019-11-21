package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.os.Bundle;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;



public class Buscar extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    //este es el boton menu
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        //codigo para que jale el boton de menu source https://www.youtube.com/watch?v=LXUDqGaToe0
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(Buscar.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.commonmenus, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        /*Toast.makeText(Buscar.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
*/
                        switch (item.getItemId()) {
                            //si te quieres ir a actividad mainmenu al seleccionar logout
                            case R.id.mnuLogout:
                                Intent launchNewIntent = new Intent(Buscar.this , MainActivity.class);
                                startActivityForResult(launchNewIntent, 0);
                                Toast.makeText(Buscar.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.mnuInicio:
                                Intent launchNewIntent1 = new Intent(Buscar.this , Buscar.class);
                                startActivityForResult(launchNewIntent1, 0);
                                Toast.makeText(Buscar.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.mnuOfertas:
                                Intent launchNewIntent2 = new Intent(Buscar.this , Buscar.class);
                                startActivityForResult(launchNewIntent2, 0);
                                Toast.makeText(Buscar.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.mnuExploraEstilos:
                                Intent launchNewIntent3 = new Intent(Buscar.this , Artista.class);
                                startActivityForResult(launchNewIntent3, 0);
                                Toast.makeText(Buscar.this, ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;

                            default: Toast.makeText(Buscar.this, "Algo paso", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }


    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored){
        if(!wasRestored){
            //Cambiar esto para el video que se necesite
            player.cueVideo("fhWaJi1Hsfo");  // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason){
        if (errorReason.isUserRecoverableError()){
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this,error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == RECOVERY_REQUEST){
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
}

//URL de tutorial Youtube
// https://www.sitepoint.com/using-the-youtube-api-to-embed-video-in-an-android-app/
