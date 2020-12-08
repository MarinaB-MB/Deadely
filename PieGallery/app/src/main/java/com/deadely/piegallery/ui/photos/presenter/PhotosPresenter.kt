package com.deadely.piegallery.ui.photos.presenter

import android.os.Bundle
import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.ui.photos.IPhotosContract
import javax.inject.Inject

class PhotosPresenter @Inject constructor() : BasePresenter<IPhotosContract.View>(), IPhotosContract.Presenter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
