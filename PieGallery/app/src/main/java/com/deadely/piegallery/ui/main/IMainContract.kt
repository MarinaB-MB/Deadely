package com.deadely.piegallery.ui.main

import com.deadely.piegallery.base.IBaseMvpPresenter
import com.deadely.piegallery.base.IBaseMvpView

interface IMainContract {
    interface View : IBaseMvpView

    interface Presenter : IBaseMvpPresenter<View>
}
