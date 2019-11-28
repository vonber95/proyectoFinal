package com.example.proyectofinal;

public class Artist {

    String nombre;
    int idImagen;


    public Artist() { }

    public Artist(String nombre, int idImagen){
        this.nombre = nombre;
        this.idImagen = idImagen;
    }


    public String getNombre() {return this.nombre; }
    public void setNombre(String nombre) {this.nombre = nombre; }

    public int getImagen(){return this.idImagen; }
    public void setIdImagen(int idImagen) { this.idImagen = idImagen; }
}
