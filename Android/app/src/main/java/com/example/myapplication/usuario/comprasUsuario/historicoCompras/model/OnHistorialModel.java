package com.example.myapplication.usuario.comprasUsuario.historicoCompras.model;

import android.util.Log;

import com.example.myapplication.usuario.comprasUsuario.historicoCompras.ContractHistorial;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.data.OnHistorialData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter.OnHistorialPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnHistorialModel implements ContractHistorial.Model {
    private OnHistorialPresenter presenter;

    public OnHistorialModel(OnHistorialPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void loadHistorialAPI(int userId, loadHistorialistener loadHistorialistener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde listado de todos los productos");
        Call<ArrayList<OnHistorialData>> call = apiService.getHistorial("PRODUCTOS.HISTORICO", userId);

        call.enqueue(new Callback<ArrayList<OnHistorialData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnHistorialData>> call, Response<ArrayList<OnHistorialData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es esto: " + response.body());
                    ArrayList<OnHistorialData> lstProd = response.body();

                    for (OnHistorialData prod : lstProd){
                        System.out.println(prod.toString());
                    }

                    if (lstProd.isEmpty()) {
                        loadHistorialistener.onFailure("No has comprado nada");
                    }else{
                        System.out.println("Has entrado en el onFinish de PRODUCTOS.HISTORICO");
                        loadHistorialistener.onFinished(lstProd);
                    }
                }else {
                    System.out.println("Hubo un error bby");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OnHistorialData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });
    }
}
