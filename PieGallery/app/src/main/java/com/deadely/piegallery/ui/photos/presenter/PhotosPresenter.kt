package com.deadely.piegallery.ui.photos.presenter

import com.deadely.piegallery.Repository
import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.ui.photos.PhotosView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PhotosPresenter @Inject constructor(private val repository: Repository) : BasePresenter<PhotosView>() {
    fun exit() {
        router.exit()
    }

    fun getPhotos() {
        // show progress
        repository.getPhotosList(1, 30)
            .doFinally {
                // hide progress
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    viewState.setPhotos(data)
                },
                { e ->
                    // show error
                }
            )
    }

    fun onRefresh() {
    }

    fun addToFavorite(photo: Photo) {
        repository.addToFavorite(photo)
    }

    fun deleteFromFavorite(photo: Photo) {
        repository.deleteFromFavorite(photo)
    }
}
