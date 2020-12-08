package com.deadely.piegallery.ui.main.presenter

import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.main.IMainContract
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<IMainContract.View>(), IMainContract.Presenter
