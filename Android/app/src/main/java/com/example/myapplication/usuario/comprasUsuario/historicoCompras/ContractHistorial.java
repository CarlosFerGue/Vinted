package com.example.myapplication.usuario.comprasUsuario.historicoCompras;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;

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
