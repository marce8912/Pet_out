package com.example.pet_out.database;

import android.content.ContentValues;
import android.content.Context;

import com.example.pet_out.Steps.RegistroActivity;
import com.example.pet_out.database.DataBaseHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class StepDAO {

    public static final String TABLE= "BdPetOut", ID = "id", NAME= "Name", LASTNAME = "Lastname", EMAIL= "Email", PHONE="Phone";
    private static final String TAG_STEP_DAO = "_StepDao_";

    public static String getSelectSQL(){
        return MessageFormat.format("SELECT {0},{1},{2},{3} FROM {4}",ID,NAME,LASTNAME,EMAIL,PHONE);
    }
    public static String[] getArray(){
        return new String[] {ID, NAME, LASTNAME, EMAIL,PHONE};
    }

    public static String getColumnsSQL(){
        return MessageFormat.format("{0} INTEGER PRIMARY KEY AUTOINCREMENT, {1} TEXT NOT NULL, {2} TEXT NOT NULL, {3} TEXT NOT NULL,{4} TEXT NOT NULL", getArray());
    }

}