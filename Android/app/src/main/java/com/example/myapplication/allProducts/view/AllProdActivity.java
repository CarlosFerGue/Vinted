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
import com.example.myapplication.beans.Producto;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;


public class AllProdActivity extends AppCompatActivity implements ContractAllProducts.View{
    private OnAllProdPresenter presenter = new OnAllProdPresenter(this);

    private static AllProdActivity mainActivity = null;

    public OnAllProdAdapter onAllProdAdapter;

    private ArrayList<OnAllProdData> lstProd;

    public static AllProdActivity getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_allprod);
        initComponents();
    }

    private void initComponents() {
        Intent intent = getIntent();
        int idUsario = intent.getIntExtra("id", -1);
        System.out.println(idUsario);
        if (idUsario != -1) {
            presenter.LoadOnAllProd(idUsario);
        }else{
            Toast.makeText(this,"No se proporciono id", Toast.LENGTH_SHORT).show();
            finish();
        }









//        presenter.LoadOnAllProd(2);
//        Bundle extras = getIntent().getExtras();
//        System.out.println("El id que ha cogido es: " + extras.getInt("id"));
//        presenter.LoadOnAllProd(extras.getInt("id"));


//        Button button = findViewById(R.id.botonValoracion);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText rate = findViewById(R.id.productRate);
//
//                String editRateStr = String.valueOf(rate.getText());
//                int addIdStr = extras.getInt("id");
//                int addIdStr = 1;
//
//                Producto producto = new Producto(addIdStr, editRateStr);
//
//            }
//        });
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
}
