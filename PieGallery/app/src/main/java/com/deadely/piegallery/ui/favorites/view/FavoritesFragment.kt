package com.deadely.piegallery.ui.favorites.view

import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.ui.favorites.IFavoritesContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(R.layout.fragment_favorites), IFavoritesContract.View {
    @Inject
    lateinit var presenter: IFavoritesContract.Presenter
    override fun initObserver() {}

    override fun setListeners() {}

    override fun initView() {}

    override fun attachPresenter() {
        presenter.attachView(this@FavoritesFragment)
    }
}
