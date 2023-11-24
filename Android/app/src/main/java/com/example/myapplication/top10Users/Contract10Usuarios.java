package com.example.myapplication.top10Users;

import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.top10Users.data.OnClick10UsuariosData;
import com.example.myapplication.top10Users.presenter.OnLoad10UserPresenter;

import java.util.ArrayList;

public interface Contract10Usuarios {
    public interface View {
        public void successLoad10Usuarios(ArrayList<OnClick10UsuariosData> lstUsuarios);

        public void successLoad10Usuarios(String err);
    }

//    public interface Presenter {
//        public void LoadOnSale(int userId);
//
//    }

    public interface Model {
        public void load10UserAPI(loadOn10UserListener loadOn10UserListener);

        public interface loadOn10UserListener {
            public void onFinished(ArrayList<OnClick10UsuariosData> lstSales);

            public void onFailure(String err);
        }

    }
}
