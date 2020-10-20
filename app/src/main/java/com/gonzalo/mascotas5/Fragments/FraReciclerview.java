package com.gonzalo.mascotas5.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.adapters.ReciclerViewAdaptador;

public class FraReciclerview extends Fragment {

    public FraReciclerview(){

    }

    private RecyclerView recyclerViewMascota;
    private ReciclerViewAdaptador adaptadorMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_fra_reciclerview, container, false);

        recyclerViewMascota = v.findViewById(R.id.reciclerMascota);
        recyclerViewMascota.setLayoutManager(new LinearLayoutManager(getActivity()));

        adaptadorMascota = new ReciclerViewAdaptador(obtenerMascotas());
        recyclerViewMascota.setAdapter(adaptadorMascota);

        return v;
    }

    public List<MascotaModelo> obtenerMascotas(){
        List<MascotaModelo> mascota = new ArrayList<>();
        mascota.add(new MascotaModelo("Rocco", 3, R.drawable.ct4));
        mascota.add(new MascotaModelo("Samito", 5, R.drawable.ct6));
        mascota.add(new MascotaModelo("Tom", 1, R.drawable.ct2));
        mascota.add(new MascotaModelo("Lola", 2, R.drawable.ct3));
        mascota.add(new MascotaModelo("Yupi", 0, R.drawable.ct1));

        return mascota;
    }

}