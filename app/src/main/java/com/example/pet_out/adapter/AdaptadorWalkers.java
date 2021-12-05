package com.example.pet_out.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pet_out.R;
import com.example.pet_out.model.Cares;
import com.example.pet_out.model.walkers;

import java.util.ArrayList;

public class AdaptadorWalkers extends RecyclerView.Adapter<AdaptadorWalkers.ViewHolderwalkers> {
    ArrayList<walkers> listwalkers;
    @NonNull
    @Override
    public ViewHolderwalkers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout,null, false);
        return new AdaptadorWalkers.ViewHolderwalkers(view) ;
    }
    public AdaptadorWalkers(ArrayList<walkers> listwalkers) {
        this.listwalkers = listwalkers;
    }
    @Override
    public void onBindViewHolder(@NonNull AdaptadorWalkers.ViewHolderwalkers holder, int position) {
        holder.Etwalker.setText(listwalkers.get(position).getName());
        holder.Etmewalker.setText(listwalkers.get(position).getInfo());
        holder.photowalker.setImageResource(listwalkers.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listwalkers.size();
    }

    public class ViewHolderwalkers extends RecyclerView.ViewHolder {
        TextView Etwalker,Etmewalker;
        ImageView photowalker;
        public ViewHolderwalkers(@NonNull View itemView) {
            super(itemView);
            Etwalker=(TextView) itemView.findViewById(R.id.txtnamefamily);
            Etmewalker=(TextView) itemView.findViewById(R.id.txtabautfamily);
            photowalker=(ImageView) itemView.findViewById(R.id.imgLinearLayaut);
        }
    }
}
