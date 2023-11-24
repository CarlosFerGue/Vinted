package com.example.myapplication.top10Users.model;

import com.example.myapplication.top10Users.Contract10Usuarios;
import com.example.myapplication.top10Users.presenter.OnLoad10UserPresenter;

public class On10UsuariosModel implements Contract10Usuarios.Model {
    private OnLoad10UserPresenter presenter;
    public On10UsuariosModel(OnLoad10UserPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void load10UserAPI(loadOn10UserListener loadOn10UserListener) {

    }
}
