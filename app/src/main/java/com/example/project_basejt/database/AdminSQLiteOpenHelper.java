package com.example.project_basejt.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) //Permite crear tablas y campos de la base de datos
    {
        //Definir mi modelo de trabajo
        db.execSQL("CREATE table compras(tipoLicor varchar primary key, marca, quienCompro text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) //Realizar cambios en esta base de datos
    {

    }
}
