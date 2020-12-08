package com.deadely.piegallery.ui.info.view

import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.ui.info.IInfoContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoFragment : BaseFragment(R.layout.fragment_info), IInfoContract.View {
    @Inject
    lateinit var presenter: IInfoContract.Presenter

    override fun initObserver() {
    }

    override fun setListeners() {
    }

    override fun initView() {
    }

    override fun attachPresenter() {
        presenter.attachView(this@InfoFragment)
    }
}
