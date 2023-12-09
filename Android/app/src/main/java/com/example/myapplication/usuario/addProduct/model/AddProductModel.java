package com.example.myapplication.usuario.addProduct.model;

import com.example.myapplication.usuario.addProduct.ContractAddProduct;
import com.example.myapplication.usuario.addProduct.data.AddProductData;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductModel implements ContractAddProduct.Model{
    ContractAddProduct.Presenter presenter;

    public AddProductModel(ContractAddProduct.Presenter presenter) {
        this.presenter = presenter;
    }
    //http://localhost:8080/Controller?ACTION=PRODUCTOS.DAR_ALTA&MARCA=lAL&PRECIO=23&IMAGEN=SDA&NOMBRE=lila&DESCRIPCION=fasfsafasfasfa&FECHA=12&ESTADO=bein&ID=1
    @Override
    public void addProductAPI(Producto producto, AddProductListener addProductListener) {

        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        System.out.println("Voy a hacer la call desde productos dar alta");
        Call<AddProductData> call = apiService.getMySales("PRODUCTOS.DAR_ALTA",
//                producto.getId_usuario(),
//                producto.getMarca(),
//                producto.getPrecio(),
//                producto.getDescripcion(),
//                producto.getNombre(),
//                producto.getImagen(),
//                producto.getEstado(),
//                producto.getFecha()
                producto.getId_usuario(),
                producto.getColor(),
                producto.getPrecio(),
                producto.getNombre(),
                producto.getMarca(),
                producto.getDescripcion(),
                producto.getEstado()
        );

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
