package com.example.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conexionbd.db.DbLibros;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class newMainActivity extends AppCompatActivity {
    EditText txtLibro, txtDescripcion, txtEditorial, txtEtiqueta;
    Button btnGuardar;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
//---------funciones del banner---------
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        /*AdView adView =(AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addKeyword(AdRequest.DEVICE_ID_EMULATOR).build();

        adView.loadAd(adRequest);*/

        //otro comentario para actualizar

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
// ---------fin de las funciones del banner---------
        txtLibro = findViewById(R.id.txt_libro);
        txtDescripcion = findViewById(R.id.txt_descripcion);
        txtEditorial = findViewById(R.id.txt_editorial);
        txtEtiqueta = findViewById(R.id.txt_etiqueta);
        btnGuardar = findViewById(R.id.btn_guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DbLibros dbLibros = new DbLibros(newMainActivity.this);
                long id = dbLibros.insertaLibro(txtLibro.getText().toString(),
                        txtEtiqueta.getText().toString(), txtEditorial.getText().toString(),
                        txtDescripcion.getText().toString());
                if (id > 0){
                    Toast.makeText(newMainActivity.this, "datos guardado correctamente",Toast.LENGTH_LONG).show();
                    limpiar();
                }else {Toast.makeText(newMainActivity.this, "error al guardar datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtLibro.setText("");
        txtEtiqueta.setText("");
        txtEditorial.setText("");
        txtDescripcion.setText("");

    }
}