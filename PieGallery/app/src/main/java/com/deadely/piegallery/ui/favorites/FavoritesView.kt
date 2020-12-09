package com.deadely.piegallery.ui.favorites

import com.deadely.piegallery.base.BaseView
import com.deadely.piegallery.dataclasses.Photo
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle
@StateStrategyType(SkipStrategy::class)
interface FavoritesView : BaseView {
    fun setPhotos(list: List<Photo>)
    fun showProgress()
    fun hideProgress()
    fun showError()
}
