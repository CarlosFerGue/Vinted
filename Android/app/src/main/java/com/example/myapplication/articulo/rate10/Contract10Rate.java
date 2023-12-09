package com.example.myapplication.articulo.rate10;

import com.example.myapplication.articulo.rate10.data.OnRate10Data;

import java.util.ArrayList;

public interface Contract10Rate {

    public interface View {
        public void successLoad10Usuarios(ArrayList<OnRate10Data> lstUsuarios);

        public void failureLoad10Usuarios(String err);
    }

    public interface Presenter {
        public void LoadOnUser();
    }

    public interface Model {
        public void load10UserAPI(loadOn10UserListener loadOn10UserListener);

        public interface loadOn10UserListener {
            public void onFinished(ArrayList<OnRate10Data> lstSales);
            //Este onFailure saldria si no hubiera usuarios literalmente jjsjsjsj
            public void onFailure(String err);
        }

    }
}
