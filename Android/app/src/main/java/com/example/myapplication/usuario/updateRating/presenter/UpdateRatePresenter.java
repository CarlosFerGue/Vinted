package com.example.myapplication.usuario.updateRating.presenter;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.updateRating.ContractUpdateRating;
import com.example.myapplication.usuario.updateRating.data.UpdateRateData;
import com.example.myapplication.usuario.updateRating.model.UpdateRateModel;

public class UpdateRatePresenter implements ContractUpdateRating.Presenter, ContractUpdateRating.Model.UpdateRatingListener {
    ContractUpdateRating.View view;
    ContractUpdateRating.Model model;

    public UpdateRatePresenter() {
        this.view = view;
        model = new UpdateRateModel(this);
    }

    @Override
    public void onFinishedRating(UpdateRateData updateRategData) {

    }

    @Override
    public void onFailureRating(String error) {

    }

    @Override
    public void updateRating(Producto producto) {
        model.updateRatingAPI(producto, this);

    }
}
