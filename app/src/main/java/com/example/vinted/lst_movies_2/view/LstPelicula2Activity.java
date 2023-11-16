package com.example.vinted.lst_movies_2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.R;
import com.example.vinted.lstMovies.LstMoviesPresenter;
import com.example.vinted.lstMovies.model.LstMoviesModel;
import com.example.vinted.lst_movies_2.ContractListMovies;
import com.example.vinted.lst_movies_2.beans.Pelicula;


import java.util.ArrayList;

public class LstPelicula2Activity extends AppCompatActivity
        implements ContractListMovies.View {

    //Activity es la pantalla que muestras
    private LstMoviesPresenter lstMoviesPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pelicula2);

        LstMoviesPresenter lstMoviesPresenter = new LstMoviesPresenter(this);
        lstMoviesPresenter.lstMovies("");

        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                lstMoviesPresenter.lstMovies("");
            }
        });
    }

    @Override
    public void successMovies(ArrayList<Pelicula> lstPelicula) {
        Toast.makeText(this, lstPelicula.get(0), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, lstPelicula.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failureMovies(String err) {

    }
}
