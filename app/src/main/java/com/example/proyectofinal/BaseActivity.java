package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    //this is to create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //if the menu button is selected display a text notification
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.mnuLogout)
        {
            Toast.makeText(this, "Logout is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));

        }
        else if (id==R.id.mnuExploraEstilos)
        {
            Toast.makeText(this, "ExploraEstilos menu is Clicked", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, Buscar.class));
        }
        else if (id==R.id.mnuInicio)
        {
            Toast.makeText(this, "Inicio menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Buscar.class));

        }
        else if (id==R.id.mnuMas)
        {
            Toast.makeText(this, "Mas.. menu is Clicked, no hay mas", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Buscar.class));

        }
        else if (id==R.id.mnuOfertas)
        {
            Toast.makeText(this, "Ofertas menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Buscar.class));

        }
        else if (id==R.id.mnuServideAtenci)
        {
            Toast.makeText(this, "Servicio de atencion menu is Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
