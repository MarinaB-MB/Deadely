package com.deadely.piegallery.ui.photos.view

import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.ui.photos.IPhotosContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhotosFragment : BaseFragment(R.layout.fragment_photos), IPhotosContract.View {
    @Inject
    lateinit var presenter: IPhotosContract.Presenter

    override fun initObserver() {}

    override fun setListeners() {}

    override fun initView() {}

    override fun attachPresenter() {
        presenter.attachView(this@PhotosFragment)
    }
}
