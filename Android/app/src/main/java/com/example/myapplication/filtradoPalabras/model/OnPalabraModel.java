package com.example.myapplication.filtradoPalabras.model;

import android.util.Log;

import com.example.myapplication.filtradoPalabras.ContractPalabra;
import com.example.myapplication.filtradoPalabras.data.OnPalabraData;
import com.example.myapplication.filtradoPalabras.presenter.OnPalabraPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnPalabraModel implements ContractPalabra.Model {
    private OnPalabraPresenter presenter;

    public OnPalabraModel(OnPalabraPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadPalabraAPI(int userId, loadPalabraListener loadPalabraListener, String palabra) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        Call<ArrayList<OnPalabraData>> call = apiService.getPalabra("PRODUCTOS.PALABRA", userId, palabra);

        call.enqueue(new Callback<ArrayList<OnPalabraData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnPalabraData>> call, Response<ArrayList<OnPalabraData>> response) {
                if (response.isSuccessful()) {
                    ArrayList<OnPalabraData> lstProd = response.body();

                    for (OnPalabraData prod : lstProd){
                        System.out.println(prod.toString());
                    }

                    if (lstProd.isEmpty()) {
                        loadPalabraListener.onFailure("No hay productos con este nombre");
                    }else{
                        loadPalabraListener.onFinished(lstProd);
                        System.out.println("Has entrado en el onfINISH del PALABRA");
                    }
                }else{
                    System.out.println("Hubo un error en ESTADO");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OnPalabraData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }

}
