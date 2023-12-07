package com.example.myapplication.allProducts.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.allProducts.ContractAllProducts;
import com.example.myapplication.allProducts.adapter.OnAllProdAdapter;
import com.example.myapplication.allProducts.data.OnAllProdData;
import com.example.myapplication.allProducts.presenter.OnAllProdPresenter;
import com.example.myapplication.filtradoPalabras.ContractPalabra;
import com.example.myapplication.filtradoPalabras.adapter.OnPalabraAdapter;
import com.example.myapplication.filtradoPalabras.data.OnPalabraData;
import com.example.myapplication.filtradoPalabras.presenter.OnPalabraPresenter;
import com.example.myapplication.filtros.ContractFiltros;
import com.example.myapplication.filtros.adapter.OnFiltrosAdapter;
import com.example.myapplication.filtros.data.OnFiltrosData;
import com.example.myapplication.filtros.presenter.OnFiltrosPresenter;

import java.util.ArrayList;


public class AllProdActivity extends AppCompatActivity implements ContractAllProducts.View, ContractFiltros.View, ContractPalabra.View {
    private OnAllProdPresenter presenter = new OnAllProdPresenter(this);

    private OnFiltrosPresenter presenterFiltros = new OnFiltrosPresenter(this);

    private OnPalabraPresenter presenterPalabras = new OnPalabraPresenter(this);

    private static AllProdActivity mainActivity = null;

    public OnAllProdAdapter onAllProdAdapter;

    private ArrayList<OnAllProdData> lstProd;
    private ArrayList<OnFiltrosData> lstProdFiltros;
    private ArrayList<OnPalabraData> lstProdPalabras;

    public static AllProdActivity getInstance() {
        return mainActivity;
    }

    private Button activo;
    private Button noActivo;
    private Button buscador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_allprod2);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        int idUsuario = intent.getIntExtra("id", -1);
        System.out.println(idUsuario);

        if (idUsuario != -1) {
            presenter.LoadOnAllProd(idUsuario);
        } else {
            Toast.makeText(this, "No se proporciono id", Toast.LENGTH_SHORT).show();
            finish();
        }





        activo = (Button) findViewById(R.id.botonActivos);
        activo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterFiltros.LoadFiltros(idUsuario, "Active");

            }
        });

        noActivo = (Button) findViewById(R.id.botonNoActivos);
        noActivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterFiltros.LoadFiltros(idUsuario, "NoActive");
            }
        });

     buscador = (Button) findViewById(R.id.buscadorBoton);
     EditText buscardorTexto = (EditText) findViewById(R.id.buscardorTexto);
     System.out.println(buscardorTexto);

     buscador.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String palabraBuscada = buscardorTexto.getText().toString();
             presenterPalabras.LoadPalabra(idUsuario, palabraBuscada);
         }
     });

    }

    @Override
    public void succesLoadFiltros(ArrayList<OnFiltrosData> lstProdFiltros) {
        this.lstProdFiltros = lstProdFiltros;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OnFiltrosAdapter onFiltrosAdapter = new OnFiltrosAdapter(this, lstProdFiltros);
        recyclerView.setAdapter(onFiltrosAdapter);
    }

    @Override
    public void succesLoadPalabra(ArrayList<OnPalabraData> lstProdPalabras) {
        this.lstProdPalabras = lstProdPalabras;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OnPalabraAdapter onPalabraAdapter = new OnPalabraAdapter(this, lstProdPalabras);
        recyclerView.setAdapter(onPalabraAdapter);
    }


    @Override
    public void succesLoadAllProd(ArrayList<OnAllProdData> lstProd) {
        this.lstProd = lstProd;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onAllProdAdapter = new OnAllProdAdapter(this, lstProd);
        recyclerView.setAdapter(onAllProdAdapter);

    }



    @Override
    public void failureLoadAllProd(String err) {
        Toast.makeText(AllProdActivity.this, err, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void failureLoadFiltros(String err) {
        Toast.makeText(AllProdActivity.this, err, Toast.LENGTH_SHORT).show();
    }



    @Override
    public void failureLoadPalabra(String err) {
        Toast.makeText(AllProdActivity.this, err, Toast.LENGTH_SHORT).show();
    }
}
