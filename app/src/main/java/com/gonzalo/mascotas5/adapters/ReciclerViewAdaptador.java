package com.gonzalo.mascotas5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.guillermo.mascotas5.Pojo.MascotaModelo;
import com.guillermo.mascotas5.R;
import com.guillermo.mascotas5.presenter.Presenter;

public class ReciclerViewAdaptador extends RecyclerView.Adapter<ReciclerViewAdaptador.ViewHolder> {

    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView likes, nombre;
        private ImageView img, Like;
//        private LinearLayout elementoClick;

        public ViewHolder(View itemView) {
            super(itemView);
            likes = itemView.findViewById(R.id.tvLikes);
            nombre = itemView.findViewById(R.id.tvNombre);
            img = itemView.findViewById(R.id.ivMascota);

            Like = itemView.findViewById(R.id.imgLike);

//            elementoClick = itemView.findViewById(R.id.elementoClick);
        }
    }

    public List<MascotaModelo> mascotaLista;

    public ReciclerViewAdaptador(List<MascotaModelo> mascotaLista) {
        this.mascotaLista = mascotaLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(mascotaLista.get(position).getNombre());
        holder.likes.setText(String.valueOf(mascotaLista.get(position).getLikes()));
        holder.img.setImageResource(mascotaLista.get(position).getFotoMascota());

        holder.Like.setOnClickListener(v -> {
            int nl = mascotaLista.get(position).getLikes() + 1;
            mascotaLista.get(position).setLikes(nl);
            holder.likes.setText(String.valueOf(nl));
            Presenter ptr = new Presenter(v, context);
            ptr.makeLike(mascotaLista.get(position).getNombre(), mascotaLista.get(position).getFotoMascota(), mascotaLista.get(position).getLikes());

        });

//        holder.elementoClick.setOnClickListener(v -> {
//            Toast.makeText(v.getContext(),String.valueOf(position) ,Toast.LENGTH_SHORT).show();
//
//        });
    }

    @Override
    public int getItemCount() {
        return mascotaLista.size();
    }
}
