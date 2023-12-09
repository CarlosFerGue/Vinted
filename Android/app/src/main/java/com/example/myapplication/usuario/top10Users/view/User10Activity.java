package com.example.myapplication.usuario.top10Users.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.usuario.top10Users.Contract10Usuarios;
import com.example.myapplication.usuario.top10Users.adapter.OnUser10Adapter;
import com.example.myapplication.usuario.top10Users.data.OnUser10Data;
import com.example.myapplication.usuario.top10Users.presenter.OnUser10Presenter;

import java.util.ArrayList;

public class User10Activity extends AppCompatActivity implements Contract10Usuarios.View {
    private OnUser10Presenter presenter = new OnUser10Presenter(this);

    private static User10Activity mainActivity = null;

    public OnUser10Adapter onUser10Adapter;

    private ArrayList<OnUser10Data> lstUsuarios;

    public static User10Activity getInstance(){
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
    public void successLoad10Usuarios(ArrayList<OnUser10Data> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
        RecyclerView recyclerView = findViewById(R.id.userRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onUser10Adapter = new OnUser10Adapter(this, lstUsuarios);
        recyclerView.setAdapter(onUser10Adapter);
    }

    @Override
    public void failureLoad10Usuarios(String err) {

    }


}