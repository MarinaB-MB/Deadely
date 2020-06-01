package com.deadely.piegallery.view.favorites;

import com.deadely.piegallery.dataclasses.Favorites;

import java.util.List;

public interface IFavoritesContract {
    interface IView {
        void showProgress();

        void setEmptyList();

        void hideProgress();

        void setPhotoList(List<Favorites> list);
    }

    interface IPresenter {
        void showProgressBar();

        void hideProgressBar();

        void clearList();

        void getPhotoList();
    }

}
