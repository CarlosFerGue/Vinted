package com.example.myapplication.filtros.model;

import com.example.myapplication.allProducts.data.OnAllProdData;
import com.example.myapplication.filtros.ContractFiltros;
import com.example.myapplication.filtros.presenter.OnFiltrosPresenter;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;

public class OnFiltrosModel implements ContractFiltros.Model {
    private OnFiltrosModel presenter;

    public OnFiltrosModel(OnFiltrosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadFiltrosAPI(int userId, loadFiltroListener loadFiltroListener) {
        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);
        Call<ArrayList<OnAllProdData>> call = apiService.getAllProducts("PRODUCTOS.FIND_ALL", userId);
    }
}
