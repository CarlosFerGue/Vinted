package com.example.vinted.lstMovies;

import com.example.vinted.lst_movies_2.beans.Pelicula;

import java.util.ArrayList;

public class LstMoviesPresenter  implements ContractListMovies.Presenter,
                                ContractListMovies.Model.OnLstMoviesListener{
    private ContractListMovies.View vista;
    private LstMoviesModel lstMoviesModel;

    @Override
    public void lstMovies(String filtro) {

    }

    @Override
    public void onFinished(ArrayList<Pelicula> lstPelicula) {

    }

    @Override
    public void onFailure(String err) {

    }
}
