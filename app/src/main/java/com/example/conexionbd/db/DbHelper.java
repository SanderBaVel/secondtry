package com.example.conexionbd.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =2;
    private static final String DATABASE_NOMBRE= "biblioteca.db";
    public static final String TABLE_LIBROS = "t_libros";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_LIBROS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom_libro TEXT NOT NULL," +
                "etiqueta TEXT NOT NULL," +
                "editorial TEXT NOT NULL, " +
                "descripcion TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_LIBROS);
        onCreate(sqLiteDatabase);
    }
}
