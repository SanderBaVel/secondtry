package com.example.conexionbd.adaptadores;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conexionbd.R;
import com.example.conexionbd.entidades.Libros;

import java.util.ArrayList;

public class ListaLibrosAdapter extends RecyclerView.Adapter<ListaLibrosAdapter.LibroViewHolder> {

    ArrayList<Libros>ListaLibros;
    public ListaLibrosAdapter(ArrayList<Libros> ListaLibros) {
        this.ListaLibros = ListaLibros;
    }



    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_libro, null, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        holder.viewNombreLibro.setText(ListaLibros.get(position).getNom_libro());
        holder.viewEtiqueta.setText(ListaLibros.get(position).getEtiqueta());
        holder.viewEditorial.setText(ListaLibros.get(position).getEditorial());
        holder.viewDescripcion.setText(ListaLibros.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return ListaLibros.size();
    }

    public class LibroViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombreLibro, viewEtiqueta, viewEditorial, viewDescripcion;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombreLibro = itemView.findViewById(R.id.view_nom_libro);
            viewEtiqueta= itemView.findViewById(R.id.view_etiqueta);
            viewEditorial = itemView.findViewById(R.id.view_editorial);
            viewDescripcion = itemView.findViewById(R.id.view_descripcion);
        }
    }
}
