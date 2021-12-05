package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pet_out.Logica.UsuarioRegister;
import com.example.pet_out.R;
import com.example.pet_out.database.DataBaseHelper;
import com.example.pet_out.model.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText name,lastname,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        Button botonContinuarRegistro = (Button) findViewById(R.id.ContinuarRegistro);
        botonContinuarRegistro.setOnClickListener(new View.OnClickListener() {
            EditText NAME=(EditText) findViewById(R.id.txtnombresRegistro);
            EditText LASTNAME=(EditText) findViewById(R.id.txtnombresRegistro);
            EditText EMAIL=(EditText) findViewById(R.id.txtnombresRegistro);
            EditText PHONE=(EditText) findViewById(R.id.txtnombresRegistro);
            @Override
            //Método botón registrar mascota
            public void onClick(View v) {
                Intent ContinuarRegistro = new Intent(RegistroActivity.this, RegistroMascotaActivity.class);
                startActivity(ContinuarRegistro);

                String name= NAME.getText().toString();
                String lastname = LASTNAME.getText().toString();
                String email = EMAIL.getText().toString ();
                String phone = PHONE.getText().toString ();

                Usuario usuario = new Usuario(name,lastname,email,phone);

                DataBaseHelper dataBaseHelper = new DataBaseHelper (RegistroActivity.this);
                UsuarioRegister usuarioRegister = new UsuarioRegister ();
                if (usuarioRegister.RegistroUsuario(dataBaseHelper,usuario)){
                    NAME.setText("");
                    LASTNAME.setText("");
                    EMAIL.setText("");
                    PHONE.setText("");
                    Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                }else {
                }
                Toast.makeText(RegistroActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
        });

    }



}