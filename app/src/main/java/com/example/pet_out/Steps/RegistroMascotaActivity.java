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
import android.widget.ImageButton;
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
                Intent Continuarapp = new Intent(RegistroMascotaActivity.this, MenuActivity.class);
                startActivity(Continuarapp);

            }
        });
        ImageButton btnfoto = (ImageButton) findViewById(R.id.btnfoto);
        btnfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Toma una foto a tu peludito", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });
    }
}