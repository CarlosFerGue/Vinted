package com.example.myapplication.filtros.model;

import android.util.Log;

import com.example.myapplication.filtros.ContractFiltros;
import com.example.myapplication.filtros.data.OnFiltrosData;
import com.example.myapplication.filtros.presenter.OnFiltrosPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnFiltrosModel implements ContractFiltros.Model {
    private OnFiltrosModel presenter;

    public OnFiltrosModel(OnFiltrosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadFiltrosAPI(int userId, loadFiltroListener loadFiltroListener, String estado) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        Call<ArrayList<OnFiltrosData>> call = apiService.getFiltros("PRODUCTOS.ESTADO", userId, estado);

        call.enqueue(new Callback<ArrayList<OnFiltrosData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnFiltrosData>> call, Response<ArrayList<OnFiltrosData>> response) {
                if (response.isSuccessful()) {
                    ArrayList<OnFiltrosData> lstProd = response.body();

                    for (OnFiltrosData prod : lstProd){
                        System.out.println(prod.toString());
                    }

                    if (lstProd.isEmpty()) {
                        loadFiltroListener.onFailure("No hay productos con este filtro");
                    }else{
                        loadFiltroListener.onFinished(lstProd);
                        System.out.println("Has entrado en el onfINISH del FILTRO");
                    }
                }else{
                    System.out.println("Hubo un error en ESTADO");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OnFiltrosData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }

}
