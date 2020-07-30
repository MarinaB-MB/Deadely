package com.deadely.itl_en.ui.stat.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.ui.stat.IStatContract
import javax.inject.Inject

class StatPresenter : BasePresenter<IStatContract.View>, IStatContract.Presenter {
    @Inject
    constructor()
}

