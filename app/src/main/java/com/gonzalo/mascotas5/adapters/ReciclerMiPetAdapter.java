package com.gonzalo.mascotas5.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.Pojo.MiPetModelo;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.presenter.Presenter;

public class ReciclerMiPetAdapter extends RecyclerView.Adapter<ReciclerMiPetAdapter.ViewHolder>  {

    private View v;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView likes;
        private ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);
            likes = itemView.findViewById(R.id.tvLikes);
            img = itemView.findViewById(R.id.ivMascota);
        }
    }

    public List<MiPetModelo> mascotaLista;

    public ReciclerMiPetAdapter(List<MiPetModelo> mascotaLista) {
        this.mascotaLista = mascotaLista;
    }

    @Override
    public ReciclerMiPetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mi_mascota, parent, false);
        ReciclerMiPetAdapter.ViewHolder viewHolder = new ReciclerMiPetAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReciclerMiPetAdapter.ViewHolder holder, int position) {
        holder.likes.setText(String.valueOf(mascotaLista.get(position).getLikes()));
        holder.img.setImageResource(mascotaLista.get(position).getFotoMascota());
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }
}
