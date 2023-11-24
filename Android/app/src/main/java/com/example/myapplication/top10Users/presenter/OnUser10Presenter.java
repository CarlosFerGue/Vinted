package com.example.myapplication.top10Users.presenter;

import com.example.myapplication.top10Users.Contract10Usuarios;
import com.example.myapplication.top10Users.data.OnUser10Data;
import com.example.myapplication.top10Users.model.OnUser10Model;

import java.util.ArrayList;

public class OnUser10Presenter implements Contract10Usuarios.Model.loadOn10UserListener {
    Contract10Usuarios.View view;
    Contract10Usuarios.Model model;
    public OnUser10Presenter(Contract10Usuarios.View view){
        this.view = view;
        model = new OnUser10Model(this);
    }


    @Override
    public void onFinished(ArrayList<OnUser10Data> lst10Users) {
        view.successLoad10Usuarios(lst10Users);
    }

    @Override
    public void onFailure(String err) {
        view.failureLoad10Usuarios(err);
    }
}
