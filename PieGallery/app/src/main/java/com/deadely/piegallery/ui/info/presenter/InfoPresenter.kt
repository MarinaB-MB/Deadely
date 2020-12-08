package com.deadely.piegallery.ui.info.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.info.IInfoContract
import javax.inject.Inject

class InfoPresenter @Inject constructor() : BasePresenter<IInfoContract.View>(), IInfoContract.Presenter
