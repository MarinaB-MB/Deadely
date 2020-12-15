package com.deadely.piegallery.ui.info.view

import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.ui.info.InfoView
import com.deadely.piegallery.ui.info.presenter.InfoPresenter
import com.deadely.piegallery.ui.main.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class InfoFragment : BaseFragment(R.layout.fragment_info), InfoView, BaseActivity.BackButtonPressed {
    @Inject
    lateinit var presenterProvider: Provider<InfoPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun setListeners() {
    }

    override fun initView() {
    }

    override fun onBackButtonPressed() {
        presenter.exit()
        (activity as MainActivity).onItemBackPressed()
    }

    override fun getExtras() {
    }
}
