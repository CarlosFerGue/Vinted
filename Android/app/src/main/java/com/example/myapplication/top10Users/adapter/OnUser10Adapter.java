package com.example.myapplication.top10Users.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.top10Users.data.OnClick10UsuariosData;

import java.util.ArrayList;

public class OnUser10Adapter extends RecyclerView.Adapter<OnUser10Adapter.ViewHolder> {
    private ArrayList<OnClick10UsuariosData> lstUsers;
    private LayoutInflater inflater;

    public OnUser10Adapter(Context context, ArrayList<OnClick10UsuariosData> lstUsers){
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OnClick10UsuariosData usuario = lstUsers.get(position);
        //Rellenamos con los datos la carta
        holder.userName.setText(lstUsers.get(position).getNombre());
        holder.userUser.setText(lstUsers.get(position).getUser());
        holder.userEmail.setText(lstUsers.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return lstUsers.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView userName;
        TextView userUser;
        TextView userEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userUser = itemView.findViewById(R.id.nombreUsuario);
            userEmail = itemView.findViewById(R.id.correoUsuario);
            userName = itemView.findViewById(R.id.nombreReal);
        }
    }
}
