package com.deadely.piegallery.ui.photos.presenter

import android.content.Context
import android.widget.Toast
import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.navigation.Screens
import com.deadely.piegallery.repository.Repository
import com.deadely.piegallery.ui.photos.PhotosView
import com.deadely.piegallery.utils.mapToModelList
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PhotosPresenter @Inject constructor(@ApplicationContext val context: Context, private val repository: Repository) : BasePresenter<PhotosView>() {
    fun exit() {
        router.exit()
    }

    var isRefreshing = true
    var page = 1

    fun getPhotos() {
        if (isRefreshing) viewState.showProgress()
        page++
        repository.getPhotosList(page, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    getFavoritesPhotos(data)
                },
                { e ->
                    e.printStackTrace()
                    viewState.showError()
                    getFavoritesPhotos(listOf())
                }
            )
    }

    private fun getFavoritesPhotos(apiData: List<Photo>) {
        repository.getFavorites().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    viewState.setPhotos(mergeLists(apiData, data.mapToModelList()))
                    if (isRefreshing) viewState.hideProgress()
                    isRefreshing = false
                },
                { e ->
                    e.printStackTrace()
                    viewState.showError()
                }
            )
    }

    private fun mergeLists(firstList: List<Photo>, secondList: List<Photo>): List<Photo> {
        // second - database
        firstList.forEach {
            it.isFavorite = !it.isFavorite
            if (!secondList.contains(it)) {
                it.isFavorite = !it.isFavorite
            }
        }
        return firstList
    }

    fun isLoadedAllItems(): Boolean {
        if (page < 10) {
            return false
        }
        return true
    }

    fun onRefresh() {
        isRefreshing = true
        page = 0
        getPhotos()
        viewState.clearList()
    }

    fun addToFavorite(photo: Photo) {
        repository.addToFavorite(photo)
    }

    fun deleteFromFavorite(photo: Photo) {
        repository.deleteFromFavorite(photo)
    }

    fun searchQuery(query: String?) {
        isRefreshing = true
        viewState.clearList()
        if (isRefreshing) viewState.showProgress()
        query?.let {
            repository.searchPhotos(query = it, perPage = 30, page = 1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { data ->
                        getFavoritesPhotos(data.results)
                        if (isRefreshing) viewState.hideProgress()
                        isRefreshing = false
                    },
                    { e ->
                        e.printStackTrace()
                        viewState.showError()
                    }
                )
        }
    }

    fun openUserProfile(photo: Photo) {
        Toast.makeText(context, photo.user?.username, Toast.LENGTH_SHORT).show()
        router.navigateTo(Screens.AuthorPageScreen(photo))
    }
}
