package com.example.pet_out.Logica;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.pet_out.Steps.RegistroActivity;
import com.example.pet_out.Steps.RegistroMascotaActivity;
import com.example.pet_out.database.DataBaseHelper;
import com.example.pet_out.database.Usuario;
import com.example.pet_out.model.StepDAO;


public class UsuarioRegister {

    public boolean RegistroUsuario (DataBaseHelper dataBaseHelper, Usuario usuario) {

        boolean Result = false;
        //Data Base
        SQLiteDatabase db = dataBaseHelper.open();


        if (!usuario.getName().isEmpty() && ! usuario.getLastname().isEmpty()&& !usuario.getEmail().isEmpty() && !usuario.getPhone().isEmpty()) {

            ContentValues values = new ContentValues();
            values.put("name", usuario.getName());
            values.put("lastname", usuario.getLastname());
            values.put("email",usuario.getEmail());
            values.put("phone",usuario.getPhone());

            Long idResultante=db.insert(StepDAO.TABLE,null,values);

            dataBaseHelper.close();


            Result= true;
        }
        return Result;
    }
}
