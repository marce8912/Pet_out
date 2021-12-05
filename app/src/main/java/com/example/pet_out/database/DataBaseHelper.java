package com.example.pet_out.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.MessageFormat;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String NAME_DB = "petOutDb.db";
    private static final int VERSION_DB = 1;
    public static final String TAG_DB = "_DataBaseHelper_";

    public DataBaseHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // db.execSQL("CREATE TABLE steps(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT)");
        db.execSQL(MessageFormat.format("CREATE TABLE {0}({1})", StepDAO.TABLE, StepDAO.getColumnsSQL()));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MessageFormat.format("DROP TABLE {0}",StepDAO.TABLE));
        onCreate(db);
    }


    public SQLiteDatabase open(){
        return getWritableDatabase();
    }

    public long insert(String table, ContentValues values){
        long rows= open().insert( table, null,values);
        close();
        return rows;

    }
    public int update(String table, ContentValues values, String where){//where => [column_name]  = ? or [column_name] = ?
        int rows = open().update(table, values, where, null);//String[] {1, "Pets"} => Object
        close();
        return  rows;
    }

    public int delete(String table, String where){
        int rows = open().delete(table,where, null);
        close();
        return rows;
    }

    public JSONArray select(String select, String[] whereArgs){ // ...where id = ? or name = ?
        //"SELECT ID,NOMBRE,FECHA FROM X"
        JSONArray array = new JSONArray();//=> JSONObject

        Cursor cursor =  open().rawQuery(select,whereArgs);
        if(cursor.getCount() < 1)
            return  array;
        if(!cursor.moveToFirst())
            return array;
        do{
            JSONObject object = new JSONObject();
            for(int a = 0; a < cursor.getColumnCount() ; a++){
                try {
                    object.put(cursor.getColumnName(a), cursor.getType(a) == Cursor.FIELD_TYPE_FLOAT ? cursor.getFloat(a):
                            cursor.getType(a) == Cursor.FIELD_TYPE_INTEGER ? cursor.getInt(a) :
                                    cursor.getType(a) == Cursor.FIELD_TYPE_STRING || cursor.getType(a) == Cursor.FIELD_TYPE_NULL ? cursor.getString(a):
                                            cursor.getBlob(a) );
                } catch (JSONException e) {
                    Log.e(TAG_DB, "select: Error select DB ",e );
                }
            }
            array.put(object);
        }while (cursor.moveToNext());
        close();
        return array;
    }

}


