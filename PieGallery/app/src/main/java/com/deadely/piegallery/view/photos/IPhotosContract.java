package com.deadely.piegallery.view.photos;

import com.deadely.piegallery.dataclasses.Photo;

import java.util.List;

public interface IPhotosContract {
    interface IPresenter {
        void refreshData();

        void getPhotoList();

        void showProgressBar();

        void hideProgressBar();
    }

    interface IView {
        void setPhotoList(List<Photo> list);

        void showErrorConn(String errorMessage);

        void showProgress();

        void hideProgress();
    }
}
