package com.example.pet_out.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pet_out.R;
import com.example.pet_out.model.Step;
import com.example.pet_out.model.Usuario;
import com.airbnb.lottie.LottieAnimationView;

public class SlideStepsFragment extends Fragment {

    private static final String ARG_STEP = "xStep";

    private Step step;

    //UI
    TextView title, sub;
    LottieAnimationView animationView;
    public SlideStepsFragment() {
        // Required empty public constructor
    }

    public static SlideStepsFragment newInstance(Usuario usuario) {
        SlideStepsFragment fragment = new SlideStepsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_STEP, usuario);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.step = (Step) getArguments().getSerializable(ARG_STEP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide_usuario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setup();
    }

    private void setup() {
        title.setText(step.getTitle());
        sub.setText(step.getSub_title());
        sub.setVisibility(Step.isShow_title() ? View.VISIBLE : View.INVISIBLE);
        animationView.setAnimation(step.getRaw_resource());
    }

    private void init(View view) {
        title = view.findViewById(R.id.text_title_steps);
        sub = view.findViewById(R.id.text_sub_steps);
        animationView = view.findViewById(R.id.img_animation_steps);
    }
}