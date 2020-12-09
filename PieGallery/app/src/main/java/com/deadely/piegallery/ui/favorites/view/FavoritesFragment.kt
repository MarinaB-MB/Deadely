package com.deadely.piegallery.ui.favorites.view

import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.ui.favorites.FavoritesView
import com.deadely.piegallery.ui.favorites.presenter.FavoritesPresenter
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(R.layout.fragment_favorites), FavoritesView {
    @Inject
    lateinit var presenterProvider: Provider<FavoritesPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun setListeners() {}

    override fun initView() {}
}
