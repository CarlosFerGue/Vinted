package com.example.myapplication.usuario.comprasUsuario.historicoCompras.model;

import android.util.Log;

import com.example.myapplication.articulo.allProducts.ContractAllProducts;
import com.example.myapplication.articulo.allProducts.data.OnAllProdData;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.presenter.OnAllProdPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnAllProdModel implements ContractAllProducts.Model {
    private OnAllProdPresenter presenter;

    public OnAllProdModel(OnAllProdPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadAllProdAPI(int userId, loadAllProdListener loadAllProdListener){
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde listado de todos los productos");
        Call<ArrayList<OnAllProdData>> call = apiService.getAllProducts("PRODUCTOS.FIND_ALL", userId);

        call.enqueue(new Callback<ArrayList<OnAllProdData>>() {
            @Override
            public void onResponse(Call<ArrayList<OnAllProdData>> call, Response<ArrayList<OnAllProdData>> response) {
                if (response.isSuccessful()) {
                    System.out.println("La peticion ha ido bien, el resultado del body es esto: " + response.body());
                    ArrayList<OnAllProdData> lstProd = response.body();

                    for (OnAllProdData prod : lstProd){
                        System.out.println(prod.toString());
                    }

                    if (lstProd.isEmpty()) {
                        loadAllProdListener.onFailure("No hay productos a la venta");
                    }else{
                        System.out.println("Has entrado en el onFinish de PRODUCTOS.FIND_ALL");
                        loadAllProdListener.onFinished(lstProd);
                    }
                }else {
                    System.out.println("Hubo un error bby");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OnAllProdData>> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());
            }
        });

    }

}
