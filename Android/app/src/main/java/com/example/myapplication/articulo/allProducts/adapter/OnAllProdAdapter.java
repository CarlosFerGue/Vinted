package com.example.myapplication.articulo.allProducts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.articulo.allProducts.data.OnAllProdData;
import com.example.myapplication.articulo.allProducts.view.AllProdActivity;
import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.updateRating.presenter.UpdateRatePresenter;

import java.util.ArrayList;

public class OnAllProdAdapter extends RecyclerView.Adapter<OnAllProdAdapter.ViewHolder> {
    private int idUsuario;
    private ArrayList<OnAllProdData> lstProd;
    private LayoutInflater inflater;



    public OnAllProdAdapter(Context context, ArrayList<OnAllProdData> lstProd, int idUsuario) {
        this.lstProd = lstProd;
        this.inflater = LayoutInflater.from(context);
        this.idUsuario = idUsuario;
    }


    @NonNull
    @Override
    public OnAllProdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sale_data_carta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnAllProdAdapter.ViewHolder holder, int position) {

        OnAllProdData prod = lstProd.get(position);

        //Rellenamos los datos de la carta
        holder.productName.setText(lstProd.get(position).getNombre());
        holder.productBrand.setText(lstProd.get(position).getMarca());
        holder.productPrice.setText(lstProd.get(position).getPrecio());
        holder.productState.setText(lstProd.get(position).getEstado());
        holder.productDesc.setText(lstProd.get(position).getDescripcion());
        holder.productRate.setText(lstProd.get(position).getValoracion());
        holder.addRateEditText.getText();



        //Cambiar puntuacion
        holder.productButton.setOnClickListener(e -> {
            System.out.println("Yeeeeesaaa All prod");
            String addRateStr = holder.addRateEditText.getText().toString().trim();
           Producto producto = new Producto(lstProd.get(position).getId_producto(),
                    addRateStr);



            System.out.println(addRateStr);
            System.out.println(producto);

            UpdateRatePresenter presenter = new UpdateRatePresenter();
            presenter.updateRating(producto);

        });


        //Comprar
        holder.botonComprar.setOnClickListener(e ->{
            String idUsuarioString = String.valueOf(idUsuario);
            Producto producto = new Producto(lstProd.get(position).getId_producto(),
                    idUsuarioString);
        });


    }

    @Override
    public int getItemCount() {
        return lstProd.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productBrand;
        TextView productPrice;
        TextView productDesc;
        TextView productState;
        TextView productColor;
        TextView productRate;
        Button productButton;
        Button botonComprar;
        EditText addRateEditText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productDesc);
            productBrand = itemView.findViewById(R.id.productBrand);
            productPrice = itemView.findViewById(R.id.productState);
            productDesc = itemView.findViewById(R.id.textProductView);
            productState = itemView.findViewById(R.id.productPrice);
            productColor = itemView.findViewById(R.id.productColor);
            productRate = itemView.findViewById(R.id.productRate);
            productButton = itemView.findViewById(R.id.botonValoracion);
            productButton = itemView.findViewById(R.id.botonComprar);
            addRateEditText = itemView.findViewById(R.id.productRate);

        }
    }
}
