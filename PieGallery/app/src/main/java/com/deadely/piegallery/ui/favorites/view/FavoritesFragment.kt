package com.deadely.piegallery.ui.favorites.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.ui.favorites.FavoriteAdapter
import com.deadely.piegallery.ui.favorites.FavoritesView
import com.deadely.piegallery.ui.favorites.presenter.FavoritesPresenter
import com.deadely.piegallery.ui.main.view.MainActivity
import com.deadely.piegallery.utils.makeGone
import com.deadely.piegallery.utils.makeVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorites.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(R.layout.fragment_favorites), FavoritesView, BaseActivity.BackButtonPressed {
    @Inject
    lateinit var presenterProvider: Provider<FavoritesPresenter>
    var favoriteAdapter = FavoriteAdapter()
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun setListeners() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.clear_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_delete -> {
                presenter.clearList()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initView() {
        favoriteAdapter.setListener(object : FavoriteAdapter.OnClickListener {

            override fun onDeleteClick(photo: Photo) {
                presenter.deleteFromFavorites(photo)
            }

            override fun onDetailClick(photo: Photo) {
                presenter.openDetailScreen(photo)
            }
        })
        rvFavList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
        }
        presenter.getFavoritesPhotos()
    }

    override fun setPhotos(list: List<Photo>) {
        if (list.isEmpty()) {
            tvEmpty.makeVisible()
            rvFavList.makeGone()
        } else {
            tvEmpty.makeGone()
            rvFavList.makeVisible()
        }
        favoriteAdapter.setData(list)
    }

    override fun showProgress() {
        pbFav.makeVisible()
        rvFavList.makeGone()
        tvEmpty.makeGone()
    }

    override fun hideProgress() {
        pbFav.makeGone()
        rvFavList.makeVisible()
    }

    override fun showError() {
        pbFav.makeGone()
        rvFavList.makeGone()
        tvEmpty.makeGone()
        // show error
    }

    override fun onBackButtonPressed() {
        presenter.exit()
        (activity as MainActivity).onItemBackPressed()
    }

    override fun getExtras() {
    }
}
