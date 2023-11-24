package com.example.myapplication.utils;

import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.top10Users.data.OnClick10UsuariosData;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.login.data.MyLoginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @GET("Controller")
    Call<MyLoginData> getDataUsers(@Query("ACTION") String action);

    @GET("Controller")
    Call<MyLoginData> getDataMovies(@Query("ACTION") String action);

    //      Login
    @GET("Controller")
    Call<MyLoginData> getLogin(@Query("ACTION") String action, @Query("EMAIL") String nombre, @Query("PASS") String pass);

    @GET("Controller")
    Call<ArrayList<OnLoadSaleData>> getMySales(@Query("ACTION") String action, @Query("ID") Integer userId);

    //    Añadir productos
    @GET("Controller")
    Call<AddProductData> getMySales(@Query("ACTION") String action,
                                    @Query("USUARIOID") int userId,
                                    @Query("MARCA") String marca,
                                    @Query("PRECIO") String precio,
                                    @Query("DESCRIPCION") String descripcion,
                                    @Query("NOMBRE") String nombre,
                                    @Query("IMAGEN") String imagen,
                                    @Query("ESTADO") String estado,
                                    @Query("FECHA") String fecha);
    // @Query("COLOR") String color);


    //  Busacr a los 10 usuarios con mas ventas
    @GET("Controller")
    Call<ArrayList<OnClick10UsuariosData>> get10Users(@Query("ACTION") String action);
}



