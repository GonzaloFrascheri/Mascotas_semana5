package com.gonzalo.mascotas5.Pojo;

public class MascotaModelo {
    private int id;
    private String nombre;
    private int fotoMascota, likes;

    public MascotaModelo(String nombre, int likes, int fotoMascota) {
        this.nombre = nombre;
        this.likes = likes;
        this.fotoMascota = fotoMascota;
    }

    public MascotaModelo(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
