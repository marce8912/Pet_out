package com.example.pet_out.Steps;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pet_out.Logica.UsuarioRegister;
import com.example.pet_out.R;
import com.example.pet_out.database.DataBaseHelper;
import com.example.pet_out.model.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText txtname, txtlastname, txtemail, txtphone,txtpasword,txtpaswordVer;
    Button bntRegister;

    private DatabaseReference Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Usuario= FirebaseDatabase.getInstance().getReference("usuarios");
        searchid();

        bntRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtname.getText().toString().isEmpty() && txtlastname.getText().toString().isEmpty() &&
                        txtemail.getText().toString().isEmpty() && txtphone.getText().toString().isEmpty()){
                    Toast.makeText(RegistroActivity.this, "Debe diligenciar todos los campos", Toast.LENGTH_SHORT).show();
                }else
                registrarUsuario();
                cleanUsuario();
                Toast.makeText(RegistroActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                pasActivity();
            }
        });
    }

    private void searchid(){
        txtname = (EditText) findViewById(R.id.txtnombresRegistro);
        txtlastname = (EditText) findViewById(R.id.txtApellidosRegistro);
        txtemail = (EditText) findViewById(R.id.txtcorreoRegistro);
        txtphone = (EditText) findViewById(R.id.txtcelularRegistro2);
        txtpasword= (EditText)findViewById(R.id.txtcontraseñaRegistro);
        txtpaswordVer= (EditText)findViewById(R.id.txtconfContraseñaRegistro2);
        bntRegister = (Button) findViewById(R.id.ContinuarRegistro);

    }
    private void registrarUsuario() {
        String name = txtname.getText().toString();
        String lastname = txtlastname.getText().toString();
        String email = txtemail.getText().toString();
        String phone = txtphone.getText().toString();
        String id = Usuario.push().getKey();
        Usuario usuarios= new Usuario(name,lastname,email,phone);
        Usuario.child("usuarios").child(id).setValue(usuarios);}


    private void cleanUsuario(){
        txtname.setText("");
        txtlastname.setText("");
        txtemail.setText("");
        txtphone.setText("");
        txtpasword.setText("");
        txtpaswordVer.setText("");

    }

    private void pasActivity() {
        Intent bntRegister = new Intent(RegistroActivity.this, RegistroMascotaActivity.class);
        startActivity(bntRegister);

    }

}

     /*       //Find fields
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

                //DataBase SQLite

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
        });*/










