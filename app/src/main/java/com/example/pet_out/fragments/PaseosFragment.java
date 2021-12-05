package com.example.pet_out.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pet_out.R;
import com.example.pet_out.adapter.AdaptadorCares;
import com.example.pet_out.adapter.AdaptadorWalkers;
import com.example.pet_out.model.Cares;
import com.example.pet_out.model.walkers;

import java.util.ArrayList;


public class PaseosFragment extends Fragment {
    ArrayList<walkers> listcwalkersVo;
    RecyclerView recyclerView;
    AdaptadorWalkers walkersAdapter;

    public PaseosFragment() {

    }


    public static PaseosFragment newInstance(String param1, String param2) {
        PaseosFragment fragment = new PaseosFragment();
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
        return inflater.inflate(R.layout.fragment_paseos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listcwalkersVo=new ArrayList<>();
        recyclerView = view.findViewById(R.id.reciclyewalkers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        AdaptadorWalkers walkersAdapter = new AdaptadorWalkers(listcwalkersVo);
        recyclerView.setAdapter(walkersAdapter);

        listcwalkersVo.add(new walkers("uno","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("dos","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("tres","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("cuatro","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book..",R.drawable.diez));
        listcwalkersVo.add(new walkers("cinco","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("seis","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("siete","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("ocho","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
        listcwalkersVo.add(new walkers("nueve","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",R.drawable.diez));
    }
}