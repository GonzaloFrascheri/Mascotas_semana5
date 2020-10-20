package com.gonzalo.mascotas5.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.model.ModelDb;

public class Presenter {

    private View view;
    private ModelDb mdb;
    private Context context;

    public Presenter(View v, Context context){
        this.view = v;
        this.context = context;
        mdb = new ModelDb(this, context);
    }

    public void makeLike(String nombre, int foto, int likes){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("foto", foto);
        contentValues.put("likes", likes);
        mdb.saveData(contentValues);
    }

    public ArrayList<MascotaModelo> getFavs(){
//        obtener los favs y retornar una lista a view
        return mdb.getFavsDb();
    }
}
