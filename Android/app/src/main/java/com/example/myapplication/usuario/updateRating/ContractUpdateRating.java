package com.example.myapplication.usuario.updateRating;

import com.example.myapplication.beans.Producto;
import com.example.myapplication.usuario.updateRating.data.UpdateRateData;

public interface ContractUpdateRating {
    public interface Model{
        public interface UpdateRatingListener{
            public void onFinishedRating(UpdateRateData updateRatingData);
            public void onFailureRating(String error);
        }
        public void updateRatingAPI(Producto producto, UpdateRatingListener UpdateRatingListener);
    }

    public interface Presenter{
        public void updateRating(Producto producto);
    }

    public interface View{
        public void onSuccessUpdateRating(UpdateRateData updateRateData);
        public void onFailureUpdateRating(String err);
    }
}
