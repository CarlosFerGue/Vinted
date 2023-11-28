package com.example.myapplication.updateRating.model;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.updateRating.ContractUpdateRating;
import com.example.myapplication.updateRating.data.UpdateRateData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateRateModel implements ContractUpdateRating.Model {
    ContractUpdateRating.Presenter presenter;

    public UpdateRateModel(ContractUpdateRating.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateRatingAPI(Producto producto, UpdateRatingListener UpdateRatingListener) {

        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde el update Rating");

        Call<UpdateRateData> call = apiService.getUpdateRating("PRODUCTOS.PUNTUAR",
                producto.getId_producto(),
                producto.getValoracion());

        call.enqueue(new Callback<UpdateRateData>() {
            @Override
            public void onResponse(Call<UpdateRateData> call, Response<UpdateRateData> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<UpdateRateData> call, Throwable t) {

            }
        });

    }
}
