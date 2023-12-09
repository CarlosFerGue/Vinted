package com.example.myapplication.usuario.login.model;

import android.util.Log;

import com.example.myapplication.beans.Usuario;
import com.example.myapplication.usuario.login.ContractLogin;
import com.example.myapplication.usuario.login.data.MyLoginData;
import com.example.myapplication.usuario.login.presenter.PresenterLogin;
import com.example.myapplication.utils.APIService;
import com.example.myapplication.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelLogin implements ContractLogin.Model {
    // ATRIBUTOS
    private static final String IP_BASE = "";
    private PresenterLogin presenter;

    // CONSTRUCTOR
    public ModelLogin(PresenterLogin presenter) {
        this.presenter = presenter;
    }

    // METODOS
    @Override
    public void loginAPI(Usuario usuario, onLoginUserListener onLoginUserListener) {

        APIService apiService = RetrofitCliente.getClient("http://10.0.2.2:8080/").create(APIService.class);

        Call<MyLoginData> call = apiService.getLogin("USUARIO.LOGIN", usuario.getEmail(), usuario.getPass());
        //http://localhost:8080/Controller?ACTION=LOGIN.LOGIN&EMAIL=alice.j@example.com&PASS=pass123
        call.enqueue(new Callback<MyLoginData>() {
            @Override
            public void onResponse(Call<MyLoginData> call, Response<MyLoginData> response) {
                if (response.isSuccessful()) {

                    System.out.println("Ha devuelto esto: " + response.body());
                    MyLoginData myLoginData = response.body();

                    if (myLoginData.getId() == 0) {
                        onLoginUserListener.onFailure("Error");

                    } else {
                        onLoginUserListener.onFinished(myLoginData);
                    }

                } else {
                    System.out.println("Ha habido un error");
                }
            }

            @Override
            public void onFailure(Call<MyLoginData> call, Throwable t) {
                Log.e("Response error", "Cuerpo del error: " + t.getMessage());

            }
        });
    }
}
