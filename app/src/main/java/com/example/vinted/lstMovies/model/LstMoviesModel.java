package com.example.vinted.lstMovies.model;

import com.example.vinted.lstMovies.ContractListMovies;
import com.example.vinted.lstMovies.LstMoviesPresenter;
import com.example.vinted.utils.ApiService;

public class LstMoviesModel implements ContractListMovies.Model {
    private static final String IP_BASE = "192.168.104.64:8080";
    private LstMoviesPresenter presenter;

    public LstMoviesModel(LstMoviesPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void moviesAPI(String filtro,
                          OnLstMoviesListener respuestaMovies) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").

    }
}
