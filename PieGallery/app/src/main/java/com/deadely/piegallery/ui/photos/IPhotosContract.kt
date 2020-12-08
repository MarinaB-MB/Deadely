package com.deadely.piegallery.ui.photos

import com.deadely.piegallery.base.IBaseMvpPresenter
import com.deadely.piegallery.base.IBaseMvpView

interface IPhotosContract {

    interface View : IBaseMvpView

    interface Presenter : IBaseMvpPresenter<View>
}
