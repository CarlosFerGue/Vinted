package com.example.myapplication.allProducts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.allProducts.data.OnAllProdData;

import java.util.ArrayList;

public class OnAllProdAdapter extends RecyclerView.Adapter<OnAllProdAdapter.ViewHolder> {
    private ArrayList<OnAllProdData> lstProd;
    private LayoutInflater inflater;

    public OnAllProdAdapter(Context context, ArrayList<OnAllProdData> lstProd){
        this.lstProd= lstProd;
        this.inflater = LayoutInflater.from(context);
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

    }

    @Override
    public int getItemCount() {
        return lstProd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        TextView productBrand;
        TextView productPrice;
        TextView productDesc;
        TextView productState;
        TextView productColor;
        TextView productRate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.textProductView);
            productBrand = itemView.findViewById(R.id.productBrand);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDesc = itemView.findViewById(R.id.productDesc);
            productState = itemView.findViewById(R.id.productState);
            productColor = itemView.findViewById(R.id.productColor);
            productRate = itemView.findViewById(R.id.productRate);


        }
    }
}
