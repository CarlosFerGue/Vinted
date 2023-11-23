package com.example.myapplication.loggedScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class OnUser10Adapter extends RecyclerView.Adapter<OnUser10Adapter.ViewHolder> {
    private ArrayList<OnUser10Adapter> lstUsers;
    private LayoutInflater inflater;

    public OnUser10Adapter(Context context, ArrayList<OnUser10Adapter> lstUsers){
        this.lstUsers = lstUsers;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public OnUser10Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_carta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnUser10Adapter.ViewHolder holder, int position) {
        
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

    }
}
