package com.example.myapplication.filtros.presenter;

import com.example.myapplication.allProducts.view.AllProdActivity;
import com.example.myapplication.filtros.ContractFiltros;
import com.example.myapplication.filtros.data.OnFiltrosData;
import com.example.myapplication.filtros.model.OnFiltrosModel;

import java.util.ArrayList;

public class OnFiltrosPresenter implements ContractFiltros.Presenter, ContractFiltros.Model.loadFiltroListener {
    ContractFiltros.View view;
    ContractFiltros.Model model;

    public OnFiltrosPresenter(ContractFiltros.View view){
        this.view = view;
        model = new OnFiltrosModel(this);
    }

    @Override
    public void LoadFiltros(int userId, String estado) {
        model.loadFiltrosAPI(userId, this, estado);
    }

    @Override
    public void onFinished(ArrayList<OnFiltrosData> lstProd) {
        view.succesLoadFiltros(lstProd);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadFiltros(err);
    }


}
