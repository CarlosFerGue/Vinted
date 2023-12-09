package com.example.myapplication.usuario.comprasUsuario.comprar;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.comprasUsuario.comprar.data.OnComprarData;

public interface ContractComprar {
    public interface Model{
        public interface CompraListener{
            public void onFinishedCompra(OnComprarData CompraData);
            public void onFailureCompra(String error);
        }
        public void CompraAPI(Producto producto, ContractComprar.Model.CompraListener CompraListener);
    }

    public interface Presenter{
        public void Compra(Producto producto);
    }

    public interface View{
        public void onSuccessCompra(OnComprarData updateRateData);
        public void onFailureCompra(String err);
    }
}
