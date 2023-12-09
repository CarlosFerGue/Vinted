package com.example.myapplication.usuario.top10Users.model;

import android.util.Log;

import com.example.myapplication.usuario.top10Users.Contract10Usuarios;
import com.example.myapplication.usuario.top10Users.data.OnUser10Data;
import com.example.myapplication.usuario.top10Users.presenter.OnUser10Presenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnUser10Model implements Contract10Usuarios.Model {
    private OnUser10Presenter presenter;

    public OnUser10Model(OnUser10Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void load10UserAPI(loadOn10UserListener loadOn10UserListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde listado 10 Usuarios");
        Call<ArrayList<OnUser10Data>> call = apiService.get10Users("USUARIO.TOP10");

        call.enqueue(new Callback<ArrayList<OnUser10Data>>() {
            @Override
            public void onResponse(Call<ArrayList<OnUser10Data>> call, Response<ArrayList<OnUser10Data>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha tenido exito, el resultado es: " + response.body());
                    ArrayList<OnUser10Data> lst10Users = response.body();
                    System.out.println(response.body());
                    for (OnUser10Data user : lst10Users) {
                        System.out.println(user.toString());
                    }
                    System.out.println("Has entrado en el onFinish de TOP10");
                    loadOn10UserListener.onFinished(lst10Users);
                } else {
                    System.out.println("Hubo un error en la carga del TOP10 mami");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<OnUser10Data>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
