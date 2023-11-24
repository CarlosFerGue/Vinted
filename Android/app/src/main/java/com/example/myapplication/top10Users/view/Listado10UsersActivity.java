package com.example.myapplication.top10Users.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.beans.Producto;

public class Listado10UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado10_users);
        initComponents();
    }


}