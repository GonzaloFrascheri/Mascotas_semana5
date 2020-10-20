package com.gonzalo.mascotas5.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.guillermo.mascotas5.Pojo.MiPetModelo;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.adapters.ReciclerMiPetAdapter;

public class FraPerfilMascota extends Fragment {

    public FraPerfilMascota(){

    }

    private RecyclerView recyclerViewMiMascota;
    private ReciclerMiPetAdapter adaptadorMiMascota;
    private TextView tvPetName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fra_perfil_mascota, container, false);

        recyclerViewMiMascota = v.findViewById(R.id.recyclerMiMascota);
//        recyclerViewMiMascota.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewMiMascota.setLayoutManager(new GridLayoutManager(getActivity(),3));

        adaptadorMiMascota = new ReciclerMiPetAdapter(obtenerMascotas());
        recyclerViewMiMascota.setAdapter(adaptadorMiMascota);

        tvPetName = v.findViewById(R.id.tvPetName);
        tvPetName.setText("Rocco");

        return v;
    }

    public List<MiPetModelo> obtenerMascotas(){

        List<MiPetModelo> mimascota = new ArrayList<>();

        mimascota.add(new MiPetModelo(0, R.drawable.ct1));
        mimascota.add(new MiPetModelo(1, R.drawable.ct2));
        mimascota.add(new MiPetModelo(2, R.drawable.ct3));
        mimascota.add(new MiPetModelo(3, R.drawable.ct4));
        mimascota.add(new MiPetModelo(4, R.drawable.ct5));
        mimascota.add(new MiPetModelo(5, R.drawable.ct6));

        return mimascota;
    }
}