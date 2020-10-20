package com.gonzalo.mascotas5.activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.adapters.ReciclerViewAdaptador;
import com.guillermo.mascotas5.model.ModelDb;
import com.guillermo.mascotas5.presenter.Presenter;

public class Favorito extends AppCompatActivity {

    private RecyclerView recyclerViewMascota;
    private ReciclerViewAdaptador adaptadorMascota;
    private View v;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        recyclerViewMascota = findViewById(R.id.reciclerMascota);
        recyclerViewMascota.setLayoutManager(new LinearLayoutManager(this));

        adaptadorMascota = new ReciclerViewAdaptador(obtenerMascotas());
        recyclerViewMascota.setAdapter(adaptadorMascota);
    }

    public List<MascotaModelo> obtenerMascotas(){
//        List<MascotaModelo> mascota = new ArrayList<>();
//        mascota.add(new MascotaModelo("Rocco", 3, R.drawable.ct4));
//        mascota.add(new MascotaModelo("Samito", 5, R.drawable.ct6));
//        mascota.add(new MascotaModelo("Tom", 1, R.drawable.ct2));
//        mascota.add(new MascotaModelo("Lola", 2, R.drawable.ct3));
//        mascota.add(new MascotaModelo("Yupi", 0, R.drawable.ct1));
//        return mascota;

        //        get favotritos
        Presenter pre = new Presenter(v, this);
        return pre.getFavs();
    }
}