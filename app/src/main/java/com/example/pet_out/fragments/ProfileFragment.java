package com.example.pet_out.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pet_out.R;
import com.example.pet_out.Steps.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    //UI
    Button registerPet, signOut;

    public ProfileFragment() {
        // Required empty public constructor
    }
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setup();
        events();
    }

    private void setup() {
    }

    private void init(View view) {
        registerPet = view.findViewById(R.id.btn_regiter_pet_profile);
        signOut = view.findViewById(R.id.btn_sign_out_pet_profile);
    }

    private void events() {
        registerPet.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.menuMascotas);
        });
        signOut.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            Intent login = new Intent(getContext(), LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(login);
        });
    }
}