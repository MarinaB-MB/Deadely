package com.deadely.piegallery.ui.photos.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.ui.photos.PhotosAdapter
import com.deadely.piegallery.ui.photos.PhotosView
import com.deadely.piegallery.ui.photos.presenter.PhotosPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_photos.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class PhotosFragment : BaseFragment(R.layout.fragment_photos), PhotosView {
    @Inject
    lateinit var presenterProvider: Provider<PhotosPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun setListeners() {
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            presenter.onRefresh()
        }
    }

    override fun initView() {
        photosAdapter.setListener(object : PhotosAdapter.OnClickListener {

            override fun addToFavorite(photo: Photo) {
                presenter.addToFavorite(photo)
            }

            override fun deleteFromFavorite(photo: Photo) {
                presenter.deleteFromFavorite(photo)
            }
        })
        rvPhotoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photosAdapter
        }
        presenter.getPhotos()
    }

    private val photosAdapter = PhotosAdapter()

    override fun setPhotos(list: List<Photo>) {
        photosAdapter.setData(list)
    }
}
