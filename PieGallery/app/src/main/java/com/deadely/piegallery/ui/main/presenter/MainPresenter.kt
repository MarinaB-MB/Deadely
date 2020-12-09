package com.deadely.piegallery.ui.main.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.main.MainView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {
    fun exit() {
        router.exit()
    }
}
