package com.example.myapplication.top10Users.presenter;

import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.top10Users.data.OnClick10UsuariosData;

import java.util.ArrayList;

public class OnLoad10UserPresenter implements ContractLoggedScreen.Presenter, ContractLoggedScreen.Model.loadOn10UserListener {
    ContractLoggedScreen.View view;
    ContractLoggedScreen.Model model;

    public OnLoad10UserPresenter(ContractLoggedScreen.View view){
        this.view;
        model = new OnLoad10UserPresenter()
    }


    @Override
    public void LoadOnSale(int userId) {

    }

    @Override
    public void onFinished(ArrayList<OnClick10UsuariosData> lstSales) {

    }

    @Override
    public void onFailure(String err) {

    }
}
