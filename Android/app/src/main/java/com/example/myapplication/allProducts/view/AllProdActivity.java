package com.example.myapplication.allProducts.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.allProducts.ContractAllProducts;
import com.example.myapplication.allProducts.adapter.OnAllProdAdapter;
import com.example.myapplication.allProducts.data.OnAllProdData;
import com.example.myapplication.allProducts.presenter.OnAllProdPresenter;

import java.util.ArrayList;


public class AllProdActivity extends AppCompatActivity implements ContractAllProducts.View{
    private OnAllProdPresenter presenter = new OnAllProdPresenter(this);

    private static AllProdActivity mainActivty = null;

    public OnAllProdAdapter onAllProdAdapter;

    private ArrayList<OnAllProdData> lstProd;

    public static AllProdActivity getInstance(){
        return mainActivty;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
    }


    @Override
    public void succesLoadAllProd(ArrayList<OnAllProdData> lstProd) {

    }

    @Override
    public void failureLoadAllProd(String err) {

    }
}
