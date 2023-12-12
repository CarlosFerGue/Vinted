package com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.ContractHistorial;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.model.OnHistorialModel;

import java.util.ArrayList;

public class OnHistorialPresenter implements ContractHistorial.Presenter, ContractHistorial.Model.loadHistorialistener {
    ContractHistorial.View view;
    ContractHistorial.Model model;

    public OnHistorialPresenter(ContractHistorial.View view) {
        this.view = view;
        model = new OnHistorialModel(this);
    }

    @Override
    public void LoadOnHistorial(int userId) {
        model.loadHistorialAPI(userId, this);
    }

    @Override
    public void onFinished(ArrayList<OnHistorialData> lstProd) {
        view.succesHistorial(lstProd);
    }

    @Override
    public void onFailure(String err) {
        view.failureHistorial(err);
    }
}
