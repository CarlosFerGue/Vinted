package com.example.myapplication.allProducts.view;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.allProducts.ContractAllProducts;

import java.util.ArrayList;


public class AllProdActivity extends AppCompatActivity implements ContractAllProducts.View{
    


    @Override
    public void succesLoadAllProd(ArrayList<OnAllProdData> lstProd) {

    }

    @Override
    public void failureLoadAllProd(String err) {

    }
}
