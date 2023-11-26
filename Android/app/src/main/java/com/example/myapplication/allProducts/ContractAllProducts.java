package com.example.myapplication.allProducts;

import com.example.myapplication.allProducts.data.OnAllProdData;

import java.util.ArrayList;

public interface ContractAllProducts {

    public interface View{
        public void succesLoadAllProd(ArrayList<OnAllProdData> lstProd);

        public void failureLoadAllProd(String err);
    }

    public interface Presenter{
        public void LoadOnAllProd(int userId);
    }

    public interface Model{
        public void loadAllProdAPI(int userId, loadAllProdListener loadAllProdListener);

        public interface loadAllProdListener{
            public void onFinished(ArrayList<OnAllProdData> lstProd);

            public void onFailure(String err);
        }
    }

}
