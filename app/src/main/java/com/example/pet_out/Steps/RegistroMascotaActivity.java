package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pet_out.R;
import com.example.pet_out.databinding.ActivityMainBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;


public class RegistroMascotaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        Button botonContinuarMascota = (Button) findViewById(R.id.btnContinuarMascota);
        botonContinuarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            //Método botón continuar app
            public void onClick(View v) {
                Intent Continuarapp = new Intent(RegistroMascotaActivity.this, InicioAppActivity.class);
                startActivity(Continuarapp);

            }
        });
    }
}