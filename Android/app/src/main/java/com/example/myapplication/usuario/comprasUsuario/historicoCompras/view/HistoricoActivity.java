package com.example.myapplication.usuario.comprasUsuario.historicoCompras.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.articulo.allProducts.adapter.OnAllProdAdapter;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.ContractHistorial;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.adapter.OnHistorialAdapter;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter.OnHistorialPresenter;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity implements ContractHistorial.View {
    private OnHistorialPresenter presenter = new OnHistorialPresenter(this);

    private static HistoricoActivity mainActivity = null;

    public OnHistorialAdapter onHistorialAdapter;

    private ArrayList<OnHistorialData> lstProd;

    private static HistoricoActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        int idUsuario = intent.getIntExtra("id", -1);
        System.out.println(idUsuario);

        if (idUsuario != -1) {
            presenter.LoadOnHistorial(idUsuario);
        } else {
            Toast.makeText(this, "No se proporciono id", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void succesHistorial(ArrayList<OnHistorialData> lstProd) {
        this.lstProd = lstProd;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onHistorialAdapter = new OnHistorialAdapter(this, lstProd, 1);
        recyclerView.setAdapter(onHistorialAdapter);
    }

    @Override
    public void failureHistorial(String err) {

    }
}
