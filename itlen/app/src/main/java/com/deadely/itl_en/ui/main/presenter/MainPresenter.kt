package com.deadely.itl_en.ui.main.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.ui.main.IMainContract
import javax.inject.Inject

class MainPresenter : BasePresenter<IMainContract.View>, IMainContract.Presenter {
    @Inject
    constructor()
}