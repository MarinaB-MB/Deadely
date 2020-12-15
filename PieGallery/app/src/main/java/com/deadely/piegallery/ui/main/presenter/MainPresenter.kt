package com.deadely.piegallery.ui.main.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.navigation.Screens
import com.deadely.piegallery.ui.main.MainView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {
    fun exit() {
        router.exit()
    }

    fun openMainPhotoListScreen() {
        router.replaceScreen(Screens.PhotosScreen())
    }

    fun openFavoriteListScreen() {
        router.replaceScreen(Screens.FavoritesScreen())
    }

    fun openInfoScreen() {
        router.replaceScreen(Screens.InfoScreen())
    }
}
