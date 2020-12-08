package com.deadely.piegallery.base;

import android.os.Bundle;

import org.jetbrains.annotations.NotNull;

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

    @Override
    public void onCreate(@NotNull Bundle savedInstanceState) {
        return;
    }

    @Override
    public void setArguments(@NotNull Object... objects) {
        return;
    }
}
