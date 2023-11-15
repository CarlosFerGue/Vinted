package com.example.vinted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.vinted.lst_movies_2.view.LstPelicula2Activity;

public class MainActivity extends AppCompatActivity {

    //Esto es el tiempo que se muestra el splash del principio
    private static final long SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Hace una transicion (activa esa vista) a LstPelicula2, la parte de Activity
             Intent mainIntent = new Intent(MainActivity.this,
                     LstPelicula2Activity.class);
             startActivity(mainIntent);
             //Aqui la inicia
             MainActivity.this.finish();
             //Esto es porque es un hilo y luego lo tenemos que cerrar
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    /*VIEW - PRESENTER - MODEL y luego al reves, MODEL(con los datos)
    * va al PRESENTER y se lo pasa al VIEW*/

}