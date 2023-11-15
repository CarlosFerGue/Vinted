package com.example.vinted.lst_movies_2;

import com.example.vinted.lst_movies_2.beans.Pelicula;

import java.util.ArrayList;

public interface ContractListMovies {

    public interface Presenter{
        void lstMovies(String filtro);
    }

    public interface Model{
        void moviesAPI(String filtro,
                       OnLstMoviesListener respuestaMovies);

        interface OnLstMoviesListener{
            void onFinished(ArrayList<Pelicula> lstPelicula);
            void onFailure(String err);
        }
    }

    public interface View{
        public void successMovies(ArrayList<Pelicula> lstPelicula);
        void failureMovies(String err);
    }

}
