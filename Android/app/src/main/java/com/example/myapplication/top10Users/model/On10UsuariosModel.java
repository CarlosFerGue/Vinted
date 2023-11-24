package com.example.myapplication.top10Users.model;

import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.top10Users.Contract10Usuarios;
import com.example.myapplication.top10Users.data.OnClick10UsuariosData;
import com.example.myapplication.top10Users.presenter.OnLoad10UserPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class On10UsuariosModel implements Contract10Usuarios.Model {
    private OnLoad10UserPresenter presenter;
    public On10UsuariosModel(OnLoad10UserPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void load10UserAPI(loadOn10UserListener loadOn10UserListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde listado 10 Usuarios");
        Call<ArrayList<OnClick10UsuariosData>> call = apiService.get10Users("USUARIO.FILTER_USUARIO");

        call.enqueue(new Callback<ArrayList<OnClick10UsuariosData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnClick10UsuariosData>> call, Response<ArrayList<OnClick10UsuariosData>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<OnClick10UsuariosData>> call, Throwable t) {

            }
        }
    }
}
