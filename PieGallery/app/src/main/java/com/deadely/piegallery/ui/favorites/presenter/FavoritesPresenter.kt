package com.deadely.piegallery.ui.favorites.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.favorites.IFavoritesContract
import javax.inject.Inject

class FavoritesPresenter @Inject constructor() : BasePresenter<IFavoritesContract.View>(), IFavoritesContract.Presenter
