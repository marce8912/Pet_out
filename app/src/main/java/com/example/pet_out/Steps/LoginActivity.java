package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.pet_out.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnRegistrarse = (Button) findViewById(R.id.Registrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            //Método botón registrarse
            public void onClick(View v) {
                Intent registrarse = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(registrarse);
            }
        });

        Button btnInicioSesion = (Button) findViewById(R.id.InicioSesion);
        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            //Método botón IniciarSesion
            public void onClick(View v) {
                Intent InicioSesion = new Intent(LoginActivity.this,InicioSesionActivity.class);
                startActivity(InicioSesion);
            }
        });

    }
}