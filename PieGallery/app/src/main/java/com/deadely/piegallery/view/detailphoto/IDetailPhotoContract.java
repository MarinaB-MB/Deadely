package com.deadely.piegallery.view.detailphoto;

import com.deadely.piegallery.dataclasses.Photo;

public interface IDetailPhotoContract {
    interface IPresenter {
        void showProgressBar();

        void hideProgressBar();

        void deleteElement(String id);

        void addElement(String id);

        void getPhoto(String id);
    }

    interface IView {
        void addToFavorite(String status);

        void deleteFromFavorite(String status);

        void showProgress();

        void showErrorConn(String errorMessage);

        void hideProgress();

        void setPhoto(Photo photo);
    }
}
