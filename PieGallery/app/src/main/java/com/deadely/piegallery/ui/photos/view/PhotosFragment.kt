package com.deadely.piegallery.ui.photos.view

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.base.BaseFragment
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.ui.photos.PhotosAdapter
import com.deadely.piegallery.ui.photos.PhotosView
import com.deadely.piegallery.ui.photos.presenter.PhotosPresenter
import com.deadely.piegallery.utils.makeGone
import com.deadely.piegallery.utils.makeVisible
import com.paginate.Paginate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_photos.*
import moxy.ktx.moxyPresenter
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class PhotosFragment : BaseFragment(R.layout.fragment_photos), PhotosView, BaseActivity.BackButtonPressed {
    @Inject
    lateinit var presenterProvider: Provider<PhotosPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }
    private var loading = false
    private var paginator: Paginate? = null
    var search = false
    private val photosAdapter = PhotosAdapter()

    override fun onPause() {
        super.onPause()
        loading = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu.findItem(R.id.mnu_search)
        menuItem.apply { setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM) }
        val searchView = menuItem.actionView as SearchView
        menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                search = true
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                search = false
                clearList()
                presenter.page = 1
                setupPaginate()
                presenter.getPhotos()
                return true
            }
        })
        with(searchView) {
            setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        presenter.searchQuery(p0)
                        rvPhotoList.smoothScrollToPosition(0)
                        searchView.clearFocus()
                        return false
                    }

                    override fun onQueryTextChange(p0: String?): Boolean {
                        return false
                    }
                }
            )
        }
    }

    override fun initView() {
        presenter.isRefreshing = true
        photosAdapter.setListener(object : PhotosAdapter.OnClickListener {

            override fun addToFavorite(photo: Photo) {
                presenter.addToFavorite(photo)
            }

            override fun deleteFromFavorite(photo: Photo) {
                presenter.deleteFromFavorite(photo)
            }

            override fun onUserDataClick(photo: Photo) {
                presenter.openUserProfile(photo)
            }

            override fun onSharePhoto(photo: Photo, bitmap: Bitmap) {
                sharePicture(photo, bitmap)
            }
        })
        rvPhotoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photosAdapter
        }
        setupPaginate()
        presenter.getPhotos()
    }

    private fun setupPaginate() {
        paginator = Paginate.with(
            rvPhotoList,
            object : Paginate.Callbacks {
                override fun onLoadMore() {
                    loading = true
                    if (!search) {
                        presenter.getPhotos()
                    } else {
                        paginator?.unbind()
                    }
                }

                override fun isLoading(): Boolean {
                    return loading
                }

                override fun hasLoadedAllItems(): Boolean {
                    if (presenter.isLoadedAllItems()) {
                        paginator?.unbind()
                        return true
                    }
                    return false
                }
            }
        ).build()
    }

    override fun setListeners() {
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            if (!loading) {
                presenter.onRefresh()
            }
        }
    }

    private fun sharePicture(photo: Photo, bitmap: Bitmap) {
        var bmpUri: Uri? = null
        bmpUri = getBitmapFromDrawable(bitmap)
        bmpUri?.let {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_STREAM, bmpUri)
                putExtra(
                    Intent.EXTRA_TEXT,
                    "${context?.getString(R.string.app_name)}" +
                        "\n ${photo.user?.username} (instagram: ${photo.user?.instagramUsername ?: "the reference is missing"})" +
                        "\n ${photo.description ?: ""}"
                )
                type = "image/*"
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(Intent.createChooser(shareIntent, "Share Image"))
        } ?: run {
            // showShareError()
            return@sharePicture
        }
    }

    override fun setPhotos(list: List<Photo>) {
        loading = false
        photosAdapter.setData(list)
    }

    override fun clearList() {
        photosAdapter.clear()
    }

    override fun showProgress() {
        pbPhotos.makeVisible()
        swipeRefresh.makeGone()
        tvStatus.makeGone()
    }

    override fun hideProgress() {
        pbPhotos.makeGone()
        tvStatus.makeGone()
        swipeRefresh.makeVisible()
    }

    override fun showError() {
        tvStatus.makeVisible()
        pbPhotos.makeGone()
        swipeRefresh.makeGone()
    }

    override fun onBackButtonPressed() {
        presenter.exit()
    }

    private fun getBitmapFromDrawable(bmp: Bitmap): Uri? {
        var bmpUri: Uri? = null
        try {
            val file = File(
                activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "share_image_" + System.currentTimeMillis() + ".png"
            )
            val out = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out)
            out.close()
            bmpUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                activity?.applicationContext?.let {
                    FileProvider.getUriForFile(
                        it,
                        "com.deadely.piegallery",
                        file
                    )
                }
            } else {
                Uri.fromFile(file)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmpUri
    }

    override fun getExtras() {
    }
}
