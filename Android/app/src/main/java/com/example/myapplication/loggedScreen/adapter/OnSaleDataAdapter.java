package com.example.myapplication.loggedScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;

import java.util.ArrayList;

public class OnSaleDataAdapter extends RecyclerView.Adapter<OnSaleDataAdapter.ViewHolder> {
    private ArrayList<OnLoadSaleData> lstSales;
    private LayoutInflater inflater;

    public OnSaleDataAdapter(Context context, ArrayList<OnLoadSaleData> lstSales){
        this.lstSales = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OnSaleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sale_data_carta_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OnLoadSaleData sale = lstSales.get(position);
        // RELLENAR CON LOS DATOS
        holder.productName.setText(lstSales.get(position).getNombre());
        holder.productBrand.setText(lstSales.get(position).getMarca());
        holder.productPrice.setText(lstSales.get(position).getPrecio());
        holder.productState.setText(lstSales.get(position).getEstado());
        holder.productDesc.setText(lstSales.get(position).getDescripcion());
        holder.productRate.setText(lstSales.get(position).getValoracion());


    }

    @Override
    public int getItemCount() {
        return lstSales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productBrand;
        TextView productPrice;
        TextView productDesc;
        TextView productState;
        TextView productColor;
        TextView productRate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productDesc);
            productBrand = itemView.findViewById(R.id.productBrand);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDesc = itemView.findViewById(R.id.textProductView);
            productState = itemView.findViewById(R.id.productState);
            productColor = itemView.findViewById(R.id.productColor);
            productRate = itemView.findViewById(R.id.productRate);




        }
    }
}
