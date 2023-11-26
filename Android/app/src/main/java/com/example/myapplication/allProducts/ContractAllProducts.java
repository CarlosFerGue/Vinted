package com.example.myapplication.allProducts;

import java.util.ArrayList;

public interface ContractAllProducts {
    public interface View{
        public void succesLoadAllProd(ArrayList<OnAllProdData> lstProd);

        public void failureLoadAllProd(String err);
    }

    public interface Presenter{
        public void LoadOnAllProd();
    }

    public interface Model{
        public void loadAllProdAPI(loadAllProdListener loadAllProdListener);

        public interface loadAllProdListener{
            public void onFinish(ArrayList<OnAllProdData> lstProd);

            public void onFailure(String err);
        }
    }

}
