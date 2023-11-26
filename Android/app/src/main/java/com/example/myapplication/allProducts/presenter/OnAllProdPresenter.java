package com.example.myapplication.allProducts.presenter;

import com.example.myapplication.allProducts.ContractAllProducts;
import com.example.myapplication.allProducts.data.OnAllProdData;
import com.example.myapplication.allProducts.model.OnAllProdModel;

import java.util.ArrayList;

public class OnAllProdPresenter implements ContractAllProducts.Presenter, ContractAllProducts.Model.loadAllProdListener{
    ContractAllProducts.View view;
    ContractAllProducts.Model model;

    public OnAllProdPresenter(ContractAllProducts.View view){
        this.view = view;
        model = new OnAllProdModel(this);
    }

    @Override
    public void LoadOnAllProd(int userId) {
        model.loadAllProdAPI(userId, this);
    }

    @Override
    public void onFinished(ArrayList<OnAllProdData> lstProd) {
        view.succesLoadAllProd(lstProd);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadAllProd(err);
    }

}
