package com.example.myapplication.articulo.rate10.presenter;

import com.example.myapplication.articulo.rate10.Contract10Rate;
import com.example.myapplication.articulo.rate10.data.OnRate10Data;
import com.example.myapplication.articulo.rate10.model.OnRate10Model;

import java.util.ArrayList;

public class OnRate10Presenter implements Contract10Rate.Model.loadOn10UserListener, Contract10Rate.Presenter{
    Contract10Rate.View view;
    Contract10Rate.Model model;

    public OnRate10Presenter(Contract10Rate.View view){
        this.view = view;
        model = new OnRate10Model(this);
    }

    @Override
    public void LoadOnUser() {
        model.load10UserAPI( this);
    }

    @Override
    public void onFinished(ArrayList<OnRate10Data> lst10Users) {
        view.successLoad10Usuarios(lst10Users);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoad10Usuarios(err);
    }


}
