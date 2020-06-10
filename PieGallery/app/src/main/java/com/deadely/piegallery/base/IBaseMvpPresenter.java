package com.deadely.piegallery.base;

public interface IBaseMvpPresenter<V extends IBaseMvpView> {
    void attachView(V mvpView);

    void detachView();
}
