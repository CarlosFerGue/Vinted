package com.example.myapplication.usuario.comprasUsuario.historicoCompras.view;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.usuario.comprasUsuario.historicoCompras.ContractHistorial;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter.OnHistorialPresenter;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity implements ContractHistorial.View {
    private OnHistorialPresenter presenter;

    private static HistoricoActivity mainActivity = null;

    public 

    @Override
    public void succesHistorial(ArrayList<OnHistorialData> lstProd) {

    }

    @Override
    public void failureHistorial(String err) {

    }
}
