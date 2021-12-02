package com.example.pet_out.Steps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.pet_out.R;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pet_out.R;

public class PaseosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paseos);

        ImageButton imgbtnPaseos = (ImageButton) findViewById(R.id.imgbtnPaseos);
        imgbtnPaseos.setOnClickListener(new View.OnClickListener() {
            @Override
            //Método botón Paseos
            public void onClick(View v) {
                Intent imgbtnPaseos = new Intent(PaseosActivity.this, CuidadoActivity.class);
                startActivity(imgbtnPaseos);
            }
        });
    }
}