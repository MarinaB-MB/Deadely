package com.deadely.piegallery.ui.authorpage.view

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import com.bumptech.glide.Glide
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.dataclasses.UserProfile
import com.deadely.piegallery.ui.authorpage.AuthorPageView
import com.deadely.piegallery.ui.authorpage.presenter.AuthorPagePresenter
import com.deadely.piegallery.utils.Constants.PHOTO
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_author_page.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class AuthorPageActivity : BaseActivity(R.layout.fragment_author_page), AuthorPageView, BaseActivity.BackButtonPressed {

    @Inject
    lateinit var presenterProvider: Provider<AuthorPagePresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun getExtras() {
        intent?.extras?.let {
            presenter.photo = it.getParcelable(PHOTO)
        }
    }

    override fun setListeners() {
    }

    override fun initView() {
    }

    override fun setPhoto(user: UserProfile) {
        Glide.with(applicationContext)
            .load(user.profileImage.large)
            .error(R.drawable.ic_no_image)
            .placeholder(R.drawable.ic_image_loading)
            .circleCrop()
            .into(ivProfile)
        tvUsername.text = user.username
        tvImagesCount.text = user.totalPhotos.toString()
        tvLikesCount.text = user.totalLikes.toString()
        tvInstagram.text = user.instagramUsername
        tvTwitter.text = user.twitterUsername
        tvPortfolio.text = user.portfolioUrl
        tvPortfolio.paintFlags = tvPortfolio.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        tvPortfolio.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(user.portfolioUrl)))
        }
    }

    override fun onBackButtonPressed() {
        presenter.exit()
    }
}
