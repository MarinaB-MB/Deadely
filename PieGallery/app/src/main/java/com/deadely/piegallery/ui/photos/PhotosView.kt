package com.deadely.piegallery.ui.photos

import com.deadely.piegallery.base.BaseView
import com.deadely.piegallery.dataclasses.Photo
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface PhotosView : BaseView {
    fun setPhotos(list: List<Photo>)
    fun showProgress()
    fun hideProgress()
    fun showError()
    fun clearList()
}
