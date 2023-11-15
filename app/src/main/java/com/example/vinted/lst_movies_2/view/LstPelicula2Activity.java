package com.example.vinted.lst_movies_2.view;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.lst_movies_2.ContractListMovies;
import com.example.vinted.lst_movies_2.beans.Pelicula;

import java.util.ArrayList;

public class LstPelicula2Activity extends AppCompatActivity
        implements ContractListMovies.View {
    //Activity es la pantalla que muestras

    private LstMoviesPresenter lstMoviesPresenter;
    @Override
    public void successMovies(ArrayList<Pelicula> lstPelicula) {

    }

    @Override
    public void failureMovies(String err) {

    }
}
