package com.example.myapplication.articulo.filtradoPalabras.presenter;

import com.example.myapplication.articulo.filtradoPalabras.ContractPalabra;
import com.example.myapplication.articulo.filtradoPalabras.data.OnPalabraData;
import com.example.myapplication.articulo.filtradoPalabras.model.OnPalabraModel;

import java.util.ArrayList;

public class OnPalabraPresenter implements ContractPalabra.Presenter, ContractPalabra.Model.loadPalabraListener {
    ContractPalabra.View view;
    ContractPalabra.Model model;

    public OnPalabraPresenter(ContractPalabra.View view){
        this.view = view;
        model = new OnPalabraModel(this);
    }

    @Override
    public void LoadPalabra(int userId, String palabra) {
        model.loadPalabraAPI(userId, this, palabra);
    }

    @Override
    public void onFinished(ArrayList<OnPalabraData> lstProd) {
        view.succesLoadPalabra(lstProd);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoadPalabra(err);
    }


}
