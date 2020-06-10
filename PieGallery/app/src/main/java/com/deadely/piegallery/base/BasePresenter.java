package com.deadely.piegallery.base;

public abstract class BasePresenter<T extends IBaseMvpView> implements IBaseMvpPresenter<T> {

    protected T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public T getMvpView() {
        return mMvpView;
    }

}
