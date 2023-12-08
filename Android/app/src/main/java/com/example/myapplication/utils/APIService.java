package com.example.myapplication.utils;

import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.allProducts.data.OnAllProdData;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.filtradoPalabras.data.OnPalabraData;
import com.example.myapplication.filtros.data.OnFiltrosData;
import com.example.myapplication.rate10.data.OnRate10Data;
import com.example.myapplication.top10Users.data.OnUser10Data;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.login.data.MyLoginData;
import com.example.myapplication.updateRating.data.UpdateRateData;

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

    // Conseguir todos los productos
    @GET("Controller")
    Call<ArrayList<OnAllProdData>> getAllProducts(@Query("ACTION") String action, @Query("ID") Integer userId);

    //    Añadir productos
    @GET("Controller")
    Call<AddProductData> getMySales(@Query("ACTION") String action,
                                    @Query("ID") int userId,
                                    @Query("COLOR") String color,
                                    @Query("PRECIO") String precio,
                                    @Query("NOMBRE") String nombre,
                                    @Query("MARCA") String marca,
                                    @Query("DESCRIPCION") String descripcion,
                                    @Query("ESTADO") String estado);
    // @Query("COLOR") String color);


    //  Busacr a los 10 usuarios con mas ventas
    @GET("Controller")
    Call<ArrayList<OnUser10Data>> get10Users(@Query("ACTION") String action);

    //  Busacar a los 10 productos con mas resenna
    @GET("Controller")
    Call<ArrayList<OnRate10Data>> get10Rates(@Query("ACTION") String action);

    // Actualizar rating
    @GET("Controller")
    Call<UpdateRateData> getUpdateRating(@Query("ACTION") String action,
                                         @Query("ID") Integer productId,
                                         @Query("VALORACION") String valoracion);

    // Comprar
    @GET("Controller")
    Call<ComprarData> getCompra(@Query("ACTION") String action,
                                         @Query("ID_ARTICULO") Integer productId,
                                         @Query("ID_USUARIO") Integer userId);

    // Historico de compras
    @GET("Controller")
    Call<ArrayList<OnHistorialData>> getFiltros(@Query("ACTION")String action,
                                              @Query("ID") Integer userId);

    // Filtros
    @GET("Controller")
    Call<ArrayList<OnFiltrosData>> getFiltros(@Query("ACTION")String action,
                                              @Query("ID") Integer userId,
                                              @Query("ESTADO")String estado);

    // Palabra
    @GET("Controller")
    Call<ArrayList<OnPalabraData>> getPalabra(@Query("ACTION")String action,
                                              @Query("ID") Integer userId,
                                              @Query("PALABRA")String palabra);

}



