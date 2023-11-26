package com.example.myapplication.allProducts.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.allProducts.data.OnAllPordData;

import java.util.ArrayList;

public class OnAllProdAdapter extends RecyclerView.Adapter<OnAllProdAdapter.ViewHolder> {
    private ArrayList<OnAllPordData> lstProd;
    private LayoutInflater inflater;


    @NonNull
    @Override
    public OnAllProdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sale_data_carta);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OnAllProdAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
