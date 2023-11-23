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
import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.loggedScreen.adapter.OnSaleDataAdapter;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.presenter.OnLoadSalePresenter;

import java.util.ArrayList;

public class LoggedScreenActivity extends AppCompatActivity implements ContractLoggedScreen.View, ContractAddProduct.View {
    private OnLoadSalePresenter presenter = new OnLoadSalePresenter(this);
    private AddProductPresenter addProductPresenter = new AddProductPresenter(this);
    private static LoggedScreenActivity mainActivity = null;
    public OnSaleDataAdapter onSaleDataAdapter;
    private ArrayList<OnLoadSaleData> lstSales;

    public static LoggedScreenActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screensss);
        initComponents();

    }

    public void initComponents() {
        Bundle extras = getIntent().getExtras();
        System.out.println("El id que has cogido es: " + extras.getInt("id"));
        presenter.LoadOnSale(extras.getInt("id"));
        Button button = findViewById(R.id.addProductButton);
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
                String addNameStr = String.valueOf(addName.getText()); //Nombre
                String addBrandStr = String.valueOf(addBrand.getText()); //Marca
                //Double addPriceStr = Double.parseDouble(String.valueOf(addPrice.getText())); //Precio
                String addPriceStr = String.valueOf(addPrice);
                String addDescStr = String.valueOf(addDesc.getText()); //Descripcion
                String addStateStr = String.valueOf(addState.getText()); //Estado
                String addColorStr = String.valueOf(addColor.getText()); //Color
                int addIdtStr = extras.getInt("id"); //Id usuario
                Producto producto = new Producto(/*extras.getInt("id")*/ addIdtStr, addBrandStr,
                        addStateStr, /*addFechaStr,*/ addDescStr, addNameStr, addPriceStr);
                addProductPresenter.addProduct(producto);

            }
        });


    }

    @Override
    public void successLoadOnSale(ArrayList<OnLoadSaleData> lstSales) {
        this.lstSales = lstSales;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        onSaleDataAdapter = new OnSaleDataAdapter(this, lstSales);
        recyclerView.setAdapter(onSaleDataAdapter);
    }

    @Override
    public void failureLoadOnSale(String err) {
        Toast.makeText(LoggedScreenActivity.this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessAddProduct(AddProductData addProductData) {

    }

    @Override
    public void onFailureAddProduct(String err) {

    }
}