package com.example.myapplication.usuario.comprasUsuario.historicoCompras.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;

import java.util.ArrayList;

public class OnHistorialAdapter extends RecyclerView.Adapter<OnHistorialAdapter.ViewHolder> {

    private int idUsuario;
    private ArrayList<OnHistorialData> lstProd;
    private LayoutInflater inflater;

    public OnHistorialAdapter(Context context, int idUsuario, ArrayList<OnHistorialData> lstProd) {
        this.idUsuario = idUsuario;
        this.lstProd = lstProd;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OnHistorialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sale_data_carta_vendida)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OnHistorialAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
