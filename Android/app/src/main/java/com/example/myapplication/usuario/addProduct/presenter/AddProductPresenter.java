package com.example.myapplication.usuario.addProduct.presenter;

import com.example.myapplication.usuario.addProduct.ContractAddProduct;
import com.example.myapplication.usuario.addProduct.data.AddProductData;
import com.example.myapplication.usuario.addProduct.model.AddProductModel;
import com.example.myapplication.beans.Producto;

public class AddProductPresenter implements ContractAddProduct.Presenter, ContractAddProduct.Model.AddProductListener {
    ContractAddProduct.View view;
    ContractAddProduct.Model model;
    public AddProductPresenter(ContractAddProduct.View view){
        this.view = view;
        model = new AddProductModel(this);
    }

    @Override
    public void onFinishedAddProduct(AddProductData addProductData) {

    }

    @Override
    public void onFailureAddProduct(String err) {

    }

    @Override
    public void addProduct(Producto producto) {
        model.addProductAPI(producto, this);
    }
}
