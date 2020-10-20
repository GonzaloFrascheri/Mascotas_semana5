package com.gonzalo.mascotas5.Pojo;

public class MiPetModelo {
    private int fotoMascota, likes;

    public MiPetModelo(int likes, int fotoMascota) {
        this.likes = likes;
        this.fotoMascota = fotoMascota;
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
}
