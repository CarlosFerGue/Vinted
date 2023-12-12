package com.example.myapplication.usuario.loggedScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.usuario.addProduct.ContractAddProduct;
import com.example.myapplication.usuario.addProduct.data.AddProductData;
import com.example.myapplication.usuario.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.articulo.allProducts.view.AllProdActivity;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.comprasUsuario.historicoCompras.view.HistoricoActivity;
import com.example.myapplication.usuario.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.usuario.loggedScreen.adapter.OnSaleDataAdapter;
import com.example.myapplication.articulo.rate10.view.Rate10Activity;
import com.example.myapplication.usuario.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.usuario.loggedScreen.presenter.OnLoadSalePresenter;
import com.example.myapplication.usuario.top10Users.view.User10Activity;

import java.util.ArrayList;

public class LoggedScreenActivity extends AppCompatActivity implements ContractLoggedScreen.View, ContractAddProduct.View {
    private OnLoadSalePresenter presenter = new OnLoadSalePresenter(this);
    private AddProductPresenter addProductPresenter = new AddProductPresenter(this);

    private static LoggedScreenActivity mainActivity = null;

    public OnSaleDataAdapter onSaleDataAdapter;
    private ArrayList<OnLoadSaleData> lstSales;
    private Button buscarUsuarios;
    private Button buscarProductos;
    private Button tusCompras;

    public static LoggedScreenActivity getInstance() {
        return mainActivity;
    }

    //Cuando le das al boton de login llama a esta funcion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screen2); //la vista que te devuelve
        initComponents(); //Llama al init components

        //De aqui para abajo es donde empieza el desarrollo del listado de 10 usuarios
        buscarUsuarios = (Button) findViewById(R.id.buscar10UsuariosBoton);
        buscarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListado10Users();
            }
        });

        //De aqui para abajo esta el buscar todos los productos
        buscarProductos = (Button) findViewById(R.id.buscarTodoProductosBoton);
        buscarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTodosProductos();
            }
        });

        //De aqui para abajo esta el buscar el top 10 productos mas valorados
        buscarProductos = (Button) findViewById(R.id.buscar10ProductosBoton);
        buscarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTop10Rate();
            }
        });

        //Boton para ver tus compras
        tusCompras = (Button) findViewById(R.id.tusCompras);
        tusCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistorico();
            }
        });
    }

    //Te lleva a la pantalla de todos los productos
    public void openHistorico() {
        Intent intent = new Intent(this, HistoricoActivity.class);
        startActivity(intent);
    }

    //Te lleva a la pantalla de todos los productos
    public void openTop10Rate() {
        Intent intent = new Intent(this, Rate10Activity.class);
        startActivity(intent);
    }

    //Te lleva a la pantalla de todos los productos
    public void openTodosProductos() {
        Bundle extras = getIntent().getExtras();
        int idUsuario = extras.getInt("id");

        Log.d("LoggedScreenActivity", "Id" + idUsuario);

        Intent intent = new Intent(this, AllProdActivity.class);
        intent.putExtra("id", idUsuario);
        startActivity(intent);
    }


    //Te lleva a la pantalla de los 10 usuarios con mas ventas
    public void openListado10Users() {
        Intent intent = new Intent(this, User10Activity.class);
        startActivity(intent);
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
                Intent intent = getIntent();
                int idUsuario = intent.getIntExtra("id", -1);

                EditText addColor = findViewById(R.id.addColor);
                EditText addPrice = findViewById(R.id.addPrice);
                EditText addName = findViewById(R.id.addName);
                EditText addBrand = findViewById(R.id.addBrand);
                EditText addDesc = findViewById(R.id.addDesc);

                String addColorStr = String.valueOf(addColor.getText());
                String addPriceStr = String.valueOf(addPrice.getText());
                String addNameStr = String.valueOf(addName.getText());
                String addBrandStr = String.valueOf(addBrand.getText());
                String addDescStr = String.valueOf(addDesc.getText());
                int addIdUserInt = idUsuario;

                Producto producto = new Producto(addIdUserInt, addColorStr, addPriceStr,
                        addNameStr, addBrandStr, addDescStr, "Active");

                addProductPresenter.addProduct(producto);

            }
        });
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