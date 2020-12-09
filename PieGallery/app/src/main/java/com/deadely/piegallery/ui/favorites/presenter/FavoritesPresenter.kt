package com.deadely.piegallery.ui.favorites.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.favorites.FavoritesView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter @Inject constructor() : BasePresenter<FavoritesView>() {
    fun exit() {
        router.exit()
    }
}
