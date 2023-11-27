package com.example.myapplication.filtros;

import com.example.myapplication.filtros.data.OnFiltrosData;

import java.util.ArrayList;

public interface ContractFiltros {

    public interface View{
        public void succesLoadFiltros(ArrayList<OnFiltrosData> lstProd);

        public void failureLoadFiltros(String err);
    }

    public interface Presenter{
        public void LoadFiltros(int userId, String estado);
    }

    public interface Model{
        public void loadFiltrosAPI(int userId, loadFiltroListener loadFiltroListener, String estado);

        public interface loadFiltroListener{
            public void onFinished(ArrayList<OnFiltrosData> lstProd);

            public void onFailure(String err);
        }
    }
}
