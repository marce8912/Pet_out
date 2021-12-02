package com.example.pet_out;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.pet_out.Logica.UsuarioRegister;
import com.example.pet_out.Steps.RegistroActivity;
import com.example.pet_out.database.DataBaseHelper;
import com.example.pet_out.database.Usuario;
import com.example.pet_out.model.StepDAO;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.pet_out", appContext.getPackageName());
    }

    public Context context;
    public RegistroActivity registroActivity;
    public UsuarioRegister usuarioRegister;
    public DataBaseHelper dataBaseHelper;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        usuarioRegister = new UsuarioRegister();
        dataBaseHelper = new DataBaseHelper(context);
    }
    @After
    public void finish(){

    }
    @Test
    public void validaRegistroUsuarioTrue(){
        Usuario usuario = new Usuario("Marcela", "Castaño", "marcecastao8@gmail.com", "3133725396");
        boolean registro=
        usuarioRegister.RegistroUsuario(dataBaseHelper,usuario);
        assertTrue(registro);
    }
    @Test
    public void validaRegistroUsuarioFalse(){
        Usuario usuario = new Usuario("", "", "", "");
        boolean registro= usuarioRegister.RegistroUsuario(dataBaseHelper,usuario);
        assertFalse(registro);
    }

}