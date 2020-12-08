package com.deadely.piegallery.di

import com.deadely.piegallery.ui.favorites.IFavoritesContract
import com.deadely.piegallery.ui.favorites.presenter.FavoritesPresenter
import com.deadely.piegallery.ui.info.IInfoContract
import com.deadely.piegallery.ui.info.presenter.InfoPresenter
import com.deadely.piegallery.ui.main.IMainContract
import com.deadely.piegallery.ui.main.presenter.MainPresenter
import com.deadely.piegallery.ui.photos.IPhotosContract
import com.deadely.piegallery.ui.photos.presenter.PhotosPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
abstract class ScreenModule {
    @ActivityScoped
    @Binds
    abstract fun bindMainPresenter(mainPresenter: MainPresenter): IMainContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun bindPhotosPresenter(photoPresenter: PhotosPresenter): IPhotosContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun bindFavoritesPresenter(favoritesPresenter: FavoritesPresenter): IFavoritesContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun bindInfoPresenter(infoPresenter: InfoPresenter): IInfoContract.Presenter
}
