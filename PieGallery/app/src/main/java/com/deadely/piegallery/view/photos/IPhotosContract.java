package com.deadely.piegallery.view.photos;

import com.deadely.piegallery.base.IBaseMvpPresenter;
import com.deadely.piegallery.base.IBaseMvpView;
import com.deadely.piegallery.dataclasses.Photo;

import java.util.List;

public interface IPhotosContract {
    interface Presenter extends IBaseMvpPresenter<View> {
        void refreshData();

        void getPhotoList();

        void showProgressBar();

        void hideProgressBar();
    }

    interface View extends IBaseMvpView {
        void setPhotoList(List<Photo> list);

        void showErrorConn(String errorMessage);

        void showProgress();

        void hideProgress();
    }
}
