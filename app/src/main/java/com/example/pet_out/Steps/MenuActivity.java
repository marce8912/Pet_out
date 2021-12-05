package com.example.pet_out.Steps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.example.pet_out.R;
import com.google.android.material.navigation.NavigationView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pet_out.R;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCierre:
                this.logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        Intent intent= new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Toast.makeText(MenuActivity.this, "Te esperamos pronto", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }


}