package com.gonzalo.mascotas5.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.presenter.Presenter;

public class ModelDb extends SQLiteOpenHelper {

    private Presenter pre;
    private Context context;

    public ModelDb(Presenter presenter, Context context){
        super(context, "dbName", null, 1);
        this.context = context;
        this.pre = presenter;
    }

    public void saveData(ContentValues contentValues){
//        Toast.makeText(context, nombre, Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("mascota", null, contentValues);
        db.close();
    }

    public ArrayList<MascotaModelo> getFavsDb(){
        ArrayList<MascotaModelo> mascotas = new ArrayList<>();
        String queryGetAll = "SELECT * FROM mascota";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros =  db.rawQuery(queryGetAll, null);

        while (registros.moveToNext()){
            MascotaModelo mascotaActual = new MascotaModelo();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setFotoMascota(registros.getInt(3));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearDb = "CREATE TABLE mascota (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "likes INTEGER, " +
                "foto INTEGER" +
                ")";
        sqLiteDatabase.execSQL(queryCrearDb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS mascota");
        onCreate(sqLiteDatabase);
    }
}
