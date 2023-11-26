package com.example.myapplication.rate10.model;

import android.util.Log;

import com.example.myapplication.rate10.Contract10Rate;
import com.example.myapplication.rate10.data.OnRate10Data;
import com.example.myapplication.rate10.presenter.OnRate10Presenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnRate10Model implements Contract10Rate.Model {
    private OnRate10Presenter presenter;

    public OnRate10Model(OnRate10Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void load10UserAPI(loadOn10UserListener loadOn10UserListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde listado 10 Usuarios");
        Call<ArrayList<OnRate10Data>> call = apiService.get10Rates("PRODUCTOS.TOP10");

        call.enqueue(new Callback<ArrayList<OnRate10Data>>() {
            @Override
            public void onResponse(Call<ArrayList<OnRate10Data>> call, Response<ArrayList<OnRate10Data>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha tenido exito, el resultado es: " + response.body());
                    ArrayList<OnRate10Data> lst10Rate = response.body();
                    System.out.println(response.body());
                    for (OnRate10Data user : lst10Rate) {
                        System.out.println(user.toString());
                    }
                    System.out.println("Has entrado en el onFinish de TOP10");
                    loadOn10UserListener.onFinished(lst10Rate);
                } else {
                    System.out.println("Hubo un error en la carga del TOP10 mami");
                }

            }

            @Override
            public void onFailure(Call<ArrayList<OnRate10Data>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
