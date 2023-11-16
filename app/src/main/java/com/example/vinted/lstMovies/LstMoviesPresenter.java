package com.example.vinted.lstMovies;

import com.example.vinted.lstMovies.model.LstMoviesModel;
import com.example.vinted.lst_movies_2.beans.Pelicula;
import com.example.vinted.lst_movies_2.view.LstPelicula2Activity;

import java.util.ArrayList;

public class LstMoviesPresenter  implements ContractListMovies.Presenter,
                                ContractListMovies.Model.OnLstMoviesListener{

    private ContractListMovies.View vista;
    private LstMoviesModel lstMoviesModel;

    public LstMoviesPresenter(ContractListMovies.View vista){
        this.vista = vista;
        lstMoviesModel = new LstMoviesModel(this);
    }
    @Override
    public void lstMovies(String filtro) {
        lstMoviesModel.moviesAPI("", this);
    }

    @Override
    public void onFinished(ArrayList<Pelicula> lstPelicula) {
        vista.successMovies(lstPelicula);
    }

    @Override
    public void onFailure(String err) {

    }
}
