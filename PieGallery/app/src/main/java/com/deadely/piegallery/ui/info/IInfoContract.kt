package com.deadely.piegallery.ui.info

import com.deadely.piegallery.base.IBaseMvpPresenter
import com.deadely.piegallery.base.IBaseMvpView

interface IInfoContract {

    interface View : IBaseMvpView

    interface Presenter : IBaseMvpPresenter<View>
}
