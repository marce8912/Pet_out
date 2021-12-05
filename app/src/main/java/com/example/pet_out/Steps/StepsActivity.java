package com.example.pet_out.Steps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pet_out.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;

public class StepsActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);



        TimerTask tarea =new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(StepsActivity.this,PaseosActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo= new Timer();
        tiempo.schedule(tarea, 5000);
    }

   /* protected void onStar (){
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref= preferences.getString("user","");
        if (!pref.equals("")){
            Toast.makeText(StepsActivity.this,"Se detecto una sesión activa", Toast.LENGTH_SHORT).show();
            this.startActivity(new Intent(this,MenuActivity.class));
        }*/
    }



