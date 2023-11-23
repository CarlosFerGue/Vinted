package com.example.myapplication.addProduct.model;

import android.util.Log;

import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductModel implements ContractAddProduct.Model{
    ContractAddProduct.Presenter presenter;

    public AddProductModel(ContractAddProduct.Presenter presenter) {
        this.presenter = presenter;
    }
    //http://localhost:8080/Controller?ACTION=PRODUCTOS.DAR_ALTA&NOMBRE=sa&MARCA=se&ID=1&IMAGEN=s&DESCRIPCION=sasa&FECHA=23&ESTADO=bIEN&PRECIO=12
    @Override
    public void addProductAPI(Producto producto, AddProductListener addProductListener) {

        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call");
        Call<AddProductData> call = apiService.getMySales("PRODUCTOS.DAR_ALTA",producto.getId_user(),
                producto.getMarca(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getNombre(),
                producto.getImagen(),
                producto.getEstado(),
                producto.getFecha());

            //    producto.getColor());

        call.enqueue(new Callback<AddProductData>() {
            @Override
            public void onResponse(Call<AddProductData> call, Response<AddProductData> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<AddProductData> call, Throwable t) {

            }
        });
    }
}
