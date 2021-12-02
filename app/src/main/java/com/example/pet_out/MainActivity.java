package com.example.pet_out;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.pet_out.model.StepDAO;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_MAIN = "_MainActivity_";

    //UI
    //CircleImageView profile;

    BottomNavigationView navigationView;
    NavHostFragment navHostFragment;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setup();
       /* Toast.makeText(this,
                "Rows: "+ StepDAO.insert(new Step(R.raw.care,"Titulo","SubTitulo"), this),
                Toast.LENGTH_LONG).show();*/
        /*Toast.makeText(this,
                "Rows: "+ StepDAO.update(
      new Step(R.raw.walk,
              getResources().getString(R.string.label_discover_pet),
              getResources().getString(R.string.label_discover_pet)),
                this),
                Toast.LENGTH_LONG).show();*/
    }

    private void changeTheme() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Log.e(TAG_MAIN, "changeTheme: Error al cambiar el tema", e);
        }
        setTheme(R.style.Theme_Pet_out);
    }

    private void setup() {
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void init(){
        navigationView = findViewById(R.id.bottom_nav_view);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
    }

    public void onPetChecked(View view) {
        Toast.makeText(this, ((RadioButton)view).getText(),Toast.LENGTH_LONG).show();
    }
}




