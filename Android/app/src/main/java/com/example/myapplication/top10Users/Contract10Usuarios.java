package com.example.myapplication.top10Users;

import com.example.myapplication.top10Users.data.OnUser10Data;

import java.util.ArrayList;

public interface Contract10Usuarios {

    public interface View {
        public void successLoad10Usuarios(ArrayList<OnUser10Data> lstUsuarios);

        public void failureLoad10Usuarios(String err);
    }

    public interface Presenter {
        public void LoadOnUser();
    }

    public interface Model {
        public void load10UserAPI(loadOn10UserListener loadOn10UserListener);

        public interface loadOn10UserListener {
            public void onFinished(ArrayList<OnUser10Data> lstSales);
            //Este onFailure saldria si no hubiera usuarios literalmente jjsjsjsj
            public void onFailure(String err);
        }

    }
}
