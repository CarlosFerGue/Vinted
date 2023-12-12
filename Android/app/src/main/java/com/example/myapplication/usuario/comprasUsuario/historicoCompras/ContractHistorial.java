package com.example.myapplication.usuario.comprasUsuario.historicoCompras;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter.OnHistorialPresenter;

import java.util.ArrayList;

public interface ContractHistorial {
    public interface View{
        public void succesHistorial(ArrayList<OnHistorialData> lstProd);

        public void failureHistorial(String err);
    }

    public interface Presenter{
        public void LoadOnHistorial(int userId);
    }

    public interface Model{
        public void loadHistorialAPI(int userId, loadHistorialistener loadHistorialistener);

        public interface loadHistorialistener{
            public void onFinished(ArrayList<OnHistorialData> lstProd);

            public void onFailure(String err);
        }
    }
}


//public interface View{
//    public void succesHistorialProd(ArrayList<OnHistorialData> lstProd);
//
//    public void failureHistorialProd(String err);
//}
//
//public interface Presenter{
//    public void LoadHistorialProd(int userId);
//}
//
//public interface Model{
//    public void loadHistorialAPI(int userId, OnHistorialPresenter.Model.loadHistorialListener loadHistorialListener);
//
//    public interface loadHistorialListener{
//        public void onFinished(ArrayList<OnHistorialData> lstProd);
//
//        public void onFailure(String err);
//    }
//}