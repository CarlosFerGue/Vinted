package com.example.myapplication.usuario.comprasUsuario.comprar.presenter;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.comprasUsuario.comprar.ContractComprar;
import com.example.myapplication.usuario.comprasUsuario.comprar.data.OnComprarData;
import com.example.myapplication.usuario.comprasUsuario.comprar.model.CompraModel;

public class ComprarPresenter implements ContractComprar.Presenter, ContractComprar.Model.CompraListener {
    ContractComprar.View view;
    ContractComprar.Model model;

    public ComprarPresenter(){
        this.view = view;
        model = new CompraModel(this);
    }

    @Override
    public void onFinishedCompra(OnComprarData CompraData) {

    }

    @Override
    public void onFailureCompra(String error) {

    }

    @Override
    public void Compra(Producto producto) {
        model.CompraAPI(producto, this);
    }
}
