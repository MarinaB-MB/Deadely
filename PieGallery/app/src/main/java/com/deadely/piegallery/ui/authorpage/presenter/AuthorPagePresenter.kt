package com.deadely.piegallery.ui.authorpage.presenter

import android.content.Context
import com.deadely.piegallery.base.BasePresenter
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.navigation.Screens
import com.deadely.piegallery.repository.Repository
import com.deadely.piegallery.ui.authorpage.AuthorPageView
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class AuthorPagePresenter @Inject constructor(@ApplicationContext val context: Context, private val repository: Repository) : BasePresenter<AuthorPageView>() {
    var photo: Photo? = null

    fun exit() {
        router.backTo(Screens.PhotosScreen())
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // show progress
        photo?.user?.username?.let { repository.getUser(it) }
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { data ->
                    viewState.setPhoto(data)
                    // hide progress
                },
                { e ->
                    // show error
                }
            )
    }
}
