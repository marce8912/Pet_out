package com.example.pet_out.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pet_out.R;
import com.example.pet_out.Steps.LoginActivity;
import com.example.pet_out.Steps.MenuActivity;
import com.example.pet_out.adapter.AdaptadorCares;
import com.example.pet_out.model.Cares;

import java.util.ArrayList;

public class GuarderiaFragment extends Fragment {

   ArrayList<Cares>listcaresVo;
   RecyclerView recyclerView;
   AdaptadorCares careAdapter;


    public GuarderiaFragment() {

    }

    public static GuarderiaFragment newInstance(String param1, String param2) {
        GuarderiaFragment fragment = new GuarderiaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guarderia, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        listcaresVo=new ArrayList<>();
        recyclerView = view.findViewById(R.id.Recycleid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        AdaptadorCares careAdapter = new AdaptadorCares(listcaresVo);
        recyclerView.setAdapter(careAdapter);


        listcaresVo.add(new Cares("uno","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("dos","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("tres","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("cuatro","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book..",R.drawable.ocho));
        listcaresVo.add(new Cares("cinco","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("seis","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("siete","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("ocho","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
        listcaresVo.add(new Cares("nueve","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.ocho));
    }


}