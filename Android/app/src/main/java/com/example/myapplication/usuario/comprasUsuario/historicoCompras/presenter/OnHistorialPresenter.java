package com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import java.util.ArrayList;

public class OnHistorialPresenter {
    public interface View{
        public void succesHistorialProd(ArrayList<OnHistorialData> lstProd);

        public void failureHistorialProd(String err);
    }

    public interface Presenter{
        public void LoadHistorialProd(int userId);
    }

    public interface Model{
        public void loadHistorialAPI(int userId, loadHistorialListener loadHistorialListener);

        public interface loadHistorialListener{
            public void onFinished(ArrayList<OnHistorialData> lstProd);

            public void onFailure(String err);
        }
    }
}
