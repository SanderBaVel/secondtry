package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.conexionbd.adaptadores.ListaLibrosAdapter;
import com.example.conexionbd.db.DbLibros;
import com.example.conexionbd.entidades.Libros;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaLibros;
    ArrayList<Libros>  listaArrayLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLibros = findViewById(R.id.listaLibros);
        listaLibros.setLayoutManager(new LinearLayoutManager(this));
        DbLibros dbLibros = new DbLibros(MainActivity.this);
        listaArrayLibros = new ArrayList<>();

        ListaLibrosAdapter adapter = new ListaLibrosAdapter(dbLibros.mostrarLibros());
        listaLibros.setAdapter(adapter);

       /* btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "base de datos creada", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
                }
            }
        });*/
    }
    //parte del menu

    public void crearRegistro(View view){
        Intent registro = new Intent(this, newMainActivity.class);
        startActivity(registro);
    }
}