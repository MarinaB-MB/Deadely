package com.deadely.piegallery.ui.favorites.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.navigation.Screens
import com.deadely.piegallery.repository.Repository
import com.deadely.piegallery.ui.favorites.FavoritesView
import com.deadely.piegallery.utils.mapToModelList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter @Inject constructor(private val repository: Repository) : BasePresenter<FavoritesView>() {
    fun exit() {
        router.replaceScreen(Screens.PhotosScreen())
    }

    fun getFavoritesPhotos() {
        viewState.showProgress()
        repository.getFavorites()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    viewState.setPhotos(data.mapToModelList())
                    viewState.hideProgress()
                },
                { e ->
                    viewState.showError()
                }
            )
    }

    fun deleteFromFavorites(photo: Photo) {
        repository.deleteFromFavorite(photo)
        getFavoritesPhotos()
    }

    fun openDetailScreen(photo: Photo) {
    }

    fun clearList() {
        repository.clearFavoriteList()
        getFavoritesPhotos()
    }
}
