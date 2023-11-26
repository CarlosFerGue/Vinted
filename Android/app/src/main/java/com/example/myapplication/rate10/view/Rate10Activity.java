package com.example.myapplication.rate10.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.rate10.Contract10Rate;
import com.example.myapplication.rate10.adapter.OnRate10Adapter;
import com.example.myapplication.rate10.data.OnRate10Data;
import com.example.myapplication.rate10.presenter.OnRate10Presenter;

import java.util.ArrayList;

public class Rate10Activity extends AppCompatActivity implements Contract10Rate.View {
    private OnRate10Presenter presenter = new OnRate10Presenter(this);

    private static Rate10Activity mainActivity = null;

    public OnRate10Adapter onRate10Adapter;

    private ArrayList<OnRate10Data> lstProd;

    public static Rate10Activity getInstance(){
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado10_users);
        initComponents();
    }


    public void initComponents(){
        presenter.LoadOnUser();
    };

    @Override
    public void successLoad10Usuarios(ArrayList<OnRate10Data> lstProd) {
        this.lstProd = lstProd;
        RecyclerView recyclerView = findViewById(R.id.userRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onRate10Adapter = new OnRate10Adapter(this, lstProd);
        recyclerView.setAdapter(onRate10Adapter);
    }

    @Override
    public void failureLoad10Usuarios(String err) {

    }


}