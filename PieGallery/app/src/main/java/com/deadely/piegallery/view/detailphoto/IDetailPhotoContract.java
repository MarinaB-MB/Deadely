package com.deadely.piegallery.view.detailphoto;

import com.deadely.piegallery.base.IBaseMvpPresenter;
import com.deadely.piegallery.base.IBaseMvpView;
import com.deadely.piegallery.dataclasses.Photo;

public interface IDetailPhotoContract {
    interface Presenter  extends IBaseMvpPresenter<View> {
        void showProgressBar();

        void hideProgressBar();

        void deleteElement(String id);

        void addElement(String id);

        void getPhoto(String id);
    }

    interface View extends IBaseMvpView {
        void addToFavorite(int status);

        void deleteFromFavorite(int status);

        void showProgress();

        void showErrorConn(String errorMessage);

        void hideProgress();

        void setPhoto(Photo photo);
    }
}
