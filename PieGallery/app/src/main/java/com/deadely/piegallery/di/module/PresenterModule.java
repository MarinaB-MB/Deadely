package com.deadely.piegallery.di.module;

import com.deadely.piegallery.view.detailphoto.IDetailPhotoContract;
import com.deadely.piegallery.view.detailphoto.presenter.DetailPhotoPresenter;
import com.deadely.piegallery.view.favorites.IFavoritesContract;
import com.deadely.piegallery.view.favorites.presenter.FavoritesPresenter;
import com.deadely.piegallery.view.info.IInfoContract;
import com.deadely.piegallery.view.info.presenter.InfoPresenter;
import com.deadely.piegallery.view.main.IMainContract;
import com.deadely.piegallery.view.main.presenter.MainPresenter;
import com.deadely.piegallery.view.photos.IPhotosContract;
import com.deadely.piegallery.view.photos.presenter.PhotosPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {
    @Binds
    abstract IFavoritesContract.Presenter bindFavoritesPresenter(FavoritesPresenter presenter);

    @Binds
    abstract IPhotosContract.Presenter bindPhotosPresenter(PhotosPresenter presenter);

    @Binds
    abstract IInfoContract.Presenter bindInfoPresenter(InfoPresenter presenter);


    @Binds
    abstract IMainContract.Presenter bindMainPresenter(MainPresenter presenter);

    @Binds
    abstract IDetailPhotoContract.Presenter bindDetailPhotoPresenter(DetailPhotoPresenter presenter);

}
