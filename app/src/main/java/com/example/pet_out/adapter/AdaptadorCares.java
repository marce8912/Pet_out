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

import java.util.ArrayList;

public class AdaptadorCares extends RecyclerView.Adapter<AdaptadorCares.ViewHoldercare> {

  ArrayList<Cares> listcares;
    @Override
    public ViewHoldercare onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout,null, false);
        return new ViewHoldercare(view) ;
    }

    public AdaptadorCares(ArrayList<Cares> listcares) {
        this.listcares = listcares;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldercare holder, int position) {
        holder.Etfamily.setText(listcares.get(position).getName());
        holder.Etinfo.setText(listcares.get(position).getInfo());
        holder.photo.setImageResource(listcares.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listcares.size();
    }

    public class ViewHoldercare extends RecyclerView.ViewHolder {
        TextView Etfamily,Etinfo;
        ImageView photo;
        public ViewHoldercare(@NonNull View itemView) {
            super(itemView);
            Etfamily=(TextView) itemView.findViewById(R.id.txtnamefamily);
            Etinfo=(TextView) itemView.findViewById(R.id.txtabautfamily);
            photo=(ImageView) itemView.findViewById(R.id.imgLinearLayaut);
        }
    }
}
