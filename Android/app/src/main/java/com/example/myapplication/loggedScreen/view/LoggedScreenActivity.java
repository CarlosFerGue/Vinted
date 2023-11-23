package com.example.myapplication.loggedScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.beans.Usuario;
import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.loggedScreen.adapter.OnSaleDataAdapter;
import com.example.myapplication.loggedScreen.data.OnClick10Usuarios;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.presenter.OnLoadSalePresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoggedScreenActivity extends AppCompatActivity implements ContractLoggedScreen.View, ContractAddProduct.View {
    private OnLoadSalePresenter presenter = new OnLoadSalePresenter(this);
    private AddProductPresenter addProductPresenter = new AddProductPresenter(this);
    private static LoggedScreenActivity mainActivity = null;
    public OnSaleDataAdapter onSaleDataAdapter;
    private ArrayList<OnLoadSaleData> lstSales;
    private ArrayList<OnClick10Usuarios> lstUsuarios;

    public static LoggedScreenActivity getInstance() {
        return mainActivity;
    }

    //Cuando le das al boton de login llama a esta funcion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screen); //la vista que te devuelve
        initComponents(); //Llama al init components

    }

    //Funcion para añadir productos
    public void initComponents() {
        Bundle extras = getIntent().getExtras();
        System.out.println("El id que has cogido es: " + extras.getInt("id"));
        presenter.LoadOnSale(extras.getInt("id"));
        Button button = findViewById(R.id.addProductButton); //con este boton llamamos a la funcion de anadir productos y ya va la cosa rodada
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos las variables del front
                EditText addName = findViewById(R.id.addName); //Nombre
                EditText addBrand = findViewById(R.id.addBrand); //Marca
                EditText addPrice = findViewById(R.id.addPrice); //Precio
                EditText addDesc = findViewById(R.id.addDesc); //Descripcion
                EditText addState = findViewById(R.id.addState); //Estado
                EditText addColor = findViewById(R.id.addColor); //Color

                //Almacenamos los valores en variables , las variables las llamamos add porque tal
                String addMarcaStr = String.valueOf(addBrand.getText());
                String addPrecioStr = String.valueOf(addPrice.getText());
                String addImageStr = String.valueOf(addBrand.getText()); //Las que pone add brand es porque no estan aun en el front
                String addNombreStr = String.valueOf(addName.getText());
                String addDescripcionStr = String.valueOf(addDesc.getText());
                String addFechaStr = String.valueOf(addBrand.getText());
                String addEstadoStr = String.valueOf(addState.getText());
                int addIdtStr = extras.getInt("id"); //Id usuario
                System.out.println(addIdtStr);

                Producto producto = new Producto(addIdtStr, addMarcaStr, addPrecioStr,
                        addImageStr, addNombreStr, addDescripcionStr, addFechaStr,
                        addEstadoStr);
                addProductPresenter.addProduct(producto);

            }
        });


    }

    //Funcion para ver top 10 usuarios
    public void buscar10Users(ArrayList<OnClick10Usuarios> lstUsuarios) {
        Button buscarUsuarios = findViewById(R.id.buscar10Usuarios);
        this.lstUsuarios = lstUsuarios;
        RecyclerView recyclerView = findViewById(R.id.)



    }



    //Si le sale bien el cargar el login te lleva a esta funcion
    @Override
    public void successLoadOnSale(ArrayList<OnLoadSaleData> lstSales) { //Aqui te llama al array de las cosas que tenga subidas como vendedor
        this.lstSales = lstSales;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView); //Esto es un recycleView que esta en el activity_logged_Screen y es para hacer el listado
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onSaleDataAdapter = new OnSaleDataAdapter(this, lstSales); //El data adapter es para meter la info dentro de las cards, asignar el nombre al id nombre y todo eso
        recyclerView.setAdapter(onSaleDataAdapter);
    }

    @Override
    public void failureLoadOnSale(String err) {
        Toast.makeText(LoggedScreenActivity.this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessAddProduct(AddProductData addProductData) {

        String mensaje = "Producto añadido correctamente";
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureAddProduct(String err) {

    }
}