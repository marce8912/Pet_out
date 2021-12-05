package com.example.pet_out.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.pet_out.fragments.SlideStepsFragment;
import com.example.pet_out.model.Usuario;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<Usuario> steps;
    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm, List<Usuario> steps) {
        super(fm);
        this.steps = steps;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return SlideStepsFragment.newInstance(steps.get(position));
    }

    @Override
    public int getCount() {
        return steps.size();
    }
}
