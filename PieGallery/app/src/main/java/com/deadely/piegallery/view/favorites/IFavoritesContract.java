package com.deadely.piegallery.view.favorites;

import com.deadely.piegallery.base.IBaseMvpPresenter;
import com.deadely.piegallery.base.IBaseMvpView;
import com.deadely.piegallery.dataclasses.Favorites;

import java.util.List;

public interface IFavoritesContract {
    interface View extends IBaseMvpView {
        void showProgress();

        void setEmptyList();

        void hideProgress();

        void setPhotoList(List<Favorites> list);
    }

    interface Presenter extends IBaseMvpPresenter<View> {
        void showProgressBar();

        void hideProgressBar();

        void clearList();

        void getPhotoList();
    }

}
