package com.deadely.itl_en.di.module;

import com.deadely.itl_en.ui.splash.ISplashScreenContract;
import com.deadely.itl_en.ui.splash.presenter.SplashScreenPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {
    @Binds
    abstract ISplashScreenContract.Presenter bindSplashScreenPresenter(SplashScreenPresenter presenter);
}
