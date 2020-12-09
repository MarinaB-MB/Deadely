package com.deadely.piegallery.ui.photos

import com.deadely.piegallery.base.BaseView
import com.deadely.piegallery.dataclasses.Photo
import moxy.viewstate.strategy.alias.AddToEndSingle

interface PhotosView : BaseView {
    @AddToEndSingle
    fun setPhotos(list: List<Photo>)
}
