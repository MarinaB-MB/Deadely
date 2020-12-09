package com.deadely.piegallery.ui.info.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.info.InfoView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class InfoPresenter @Inject constructor() : BasePresenter<InfoView>() {
    fun exit() {
        router.exit()
    }
}
