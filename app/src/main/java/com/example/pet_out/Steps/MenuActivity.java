package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.example.pet_out.R;
import com.google.android.material.navigation.NavigationView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView iconMenu;
    NavigationView navigationView;
    NavHostFragment navHostFragment;
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        events();
        setup();
    }

    @SuppressLint("WrongConstant")
    private void setup() {
        navigationView.setItemIconTintList(null);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navigationView, navController);
    }

        @SuppressLint("WrongConstant")
        private void events() {
            iconMenu.setOnClickListener(v -> {
                drawerLayout.openDrawer(Gravity.START);
            });
        }

        private void init() {
            drawerLayout = findViewById(R.id.menulayout);
            iconMenu = findViewById(R.id.imgtoolbar);
            navigationView = findViewById(R.id.navigationView);
            navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.mainFrag);
        }
    }
