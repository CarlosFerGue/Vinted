package com.example.myapplication.filtradoPalabras;

import com.example.myapplication.filtradoPalabras.data.OnPalabraData;

import java.util.ArrayList;

public interface ContractPalabra {

    public interface View{
        public void succesLoadPalabra(ArrayList<OnPalabraData> lstProd);

        public void failureLoadPalabra(String err);
    }

    public interface Presenter{
        public void LoadPalabra(int userId, String palabra);
    }

    public interface Model{
        public void loadPalabraAPI(int userId, loadPalabraListener loadPalabraListener, String palabra);

        public interface loadPalabraListener{
            public void onFinished(ArrayList<OnPalabraData> lstProd);

            public void onFailure(String err);
        }
    }
}
