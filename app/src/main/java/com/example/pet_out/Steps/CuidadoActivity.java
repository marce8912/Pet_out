package com.example.pet_out.Steps;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.pet_out.R;

public class CuidadoActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION = 102;
    String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.SEND_SMS};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidado);


        ImageButton imgbtnCuidado = findViewById(R.id.imgbtnCuidado);
        imgbtnCuidado.setOnClickListener(new View.OnClickListener() {


            @Override
            //Método botón Paseos
            public void onClick(View v) {
                if(!validatePermission()) {
                    setRequestPermission();
                    return;
                }else{
                    Intent imgbtnCuidado = new Intent(CuidadoActivity.this, LoginActivity.class);
                    startActivity(imgbtnCuidado);
                }

            }

        });

    }

    private boolean validatePermission() {
        return (ContextCompat.checkSelfPermission(CuidadoActivity.this, permissions[0]) +
                ContextCompat.checkSelfPermission(CuidadoActivity.this, permissions[1]) +
                ContextCompat.checkSelfPermission(CuidadoActivity.this, permissions[2]) +
                ContextCompat.checkSelfPermission(CuidadoActivity.this, permissions[3]) ==
                PackageManager.PERMISSION_GRANTED);
    }

    private void setRequestPermission() {

        if (!validatePermission()) {
            //Solicitar los permisos
            if (!ActivityCompat.shouldShowRequestPermissionRationale(CuidadoActivity.this, permissions[0]) ||
                    !ActivityCompat.shouldShowRequestPermissionRationale(CuidadoActivity.this, permissions[1]) ||
                    !ActivityCompat.shouldShowRequestPermissionRationale(CuidadoActivity.this, permissions[2]) ||
                    !ActivityCompat.shouldShowRequestPermissionRationale(CuidadoActivity.this, permissions[3])) {
                //Justificacion
                AlertDialog alert = new AlertDialog.Builder(CuidadoActivity.this)
                        .setTitle("Solicitud de permisos")
                        .setMessage("Se requiere de los permisos para continuar con el proceso")
                        .setPositiveButton("Aceptar", ((dialog, which) -> {
                            //El dialogo de los permisos
                            ActivityCompat.requestPermissions(CuidadoActivity.this, permissions, REQUEST_PERMISSION);
                        }))
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                alert.show();

            }
        } else
            Toast.makeText(CuidadoActivity.this, "Permisos Garantizados!!!", Toast.LENGTH_SHORT).show();
            //Intent imgbtnCuidado = new Intent(CuidadoActivity.this, LoginActivity.class);
            //startActivity(imgbtnCuidado);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && (grantResults[0] + grantResults[1] + grantResults[2] + grantResults[3] == PackageManager.PERMISSION_GRANTED))
                Toast.makeText(CuidadoActivity.this, "Permisos Garantizados!!!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(CuidadoActivity.this, "Permisos Denegados :c", Toast.LENGTH_SHORT).show();
           
        }
        
        
        }

    }







