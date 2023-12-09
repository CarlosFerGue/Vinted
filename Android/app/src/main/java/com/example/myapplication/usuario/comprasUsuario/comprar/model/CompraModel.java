package com.example.myapplication.usuario.comprasUsuario.comprar.model;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.comprasUsuario.comprar.ContractComprar;
import com.example.myapplication.usuario.comprasUsuario.comprar.data.OnComprarData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompraModel implements ContractComprar.Model {
    ContractComprar.Presenter presenter;

    public CompraModel(ContractComprar.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void CompraAPI(Producto producto,  CompraListener CompraListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde el comprar");

        Call<OnComprarData> call = apiService.getCompra("PRODUCTOS.COMPRAR",
                producto.getId_producto(),
                producto.getId_Comprador());

        call.enqueue(new Callback<OnComprarData>() {
            @Override
            public void onResponse(Call<OnComprarData> call, Response<OnComprarData> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<OnComprarData> call, Throwable t) {

            }
        });

    }
}
