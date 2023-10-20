package com.example.conexionbd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.conexionbd.entidades.Libros;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DbLibros extends DbHelper{
    Context context;
    public DbLibros(@Nullable Context context) {
        super(context);
        this.context =context;
    }
    public long insertaLibro(String nombre, String etiqueta,String editorial, String descripcion){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nom_libro", nombre);
            values.put("etiqueta", etiqueta);
            values.put("editorial", editorial);
            values.put("descripcion", descripcion);
            id = db.insert(TABLE_LIBROS, null, values);

        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<Libros> mostrarLibros(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        ArrayList<Libros> listaLibros = new ArrayList<>();
        Libros libros = null;
        Cursor cursorLibros=null;

        cursorLibros = db.rawQuery("SELECT * FROM " + TABLE_LIBROS, null);
        if (cursorLibros.moveToFirst()){
            do {
                libros = new Libros();
                libros.setId(cursorLibros.getInt(0));
                libros.setNom_libro(cursorLibros.getString(1));
                libros.setEtiqueta(cursorLibros.getString(2));
                libros.setEditorial(cursorLibros.getString(3));
                libros.setDescripcion(cursorLibros.getString(4));
                listaLibros.add(libros);
            }while (cursorLibros.moveToNext());

        }
        cursorLibros.close();
        return listaLibros;
    }
}
