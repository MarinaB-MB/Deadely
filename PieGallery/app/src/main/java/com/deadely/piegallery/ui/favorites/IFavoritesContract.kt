package com.deadely.piegallery.ui.favorites

import com.deadely.piegallery.base.IBaseMvpPresenter
import com.deadely.piegallery.base.IBaseMvpView

interface IFavoritesContract {

    interface View : IBaseMvpView

    interface Presenter : IBaseMvpPresenter<View>
}
