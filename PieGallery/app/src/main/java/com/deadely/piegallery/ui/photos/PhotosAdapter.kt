package com.deadely.piegallery.ui.photos

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.bumptech.glide.Glide
import com.ddd.androidutils.DoubleClick
import com.ddd.androidutils.DoubleClickListener
import com.deadely.piegallery.R
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.utils.makeVisible
import kotlinx.android.synthetic.main.row_photo_post.view.*

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    private var dataList = mutableListOf<Photo>()
    fun setData(list: List<Photo>) {
        dataList.apply {
            addAll(list)
        }
        notifyDataSetChanged()
    }

    private var listener: OnClickListener? = null
    fun setListener(clickListener: OnClickListener) {
        listener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_photo_post, parent, false)
    )

    override fun onBindViewHolder(holder: PhotosAdapter.ViewHolder, position: Int) = holder.bind(dataList[position])

    override fun getItemCount(): Int = dataList.size

    fun clear() {
        dataList = mutableListOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var avd: AnimatedVectorDrawableCompat? = null
        var avd2: AnimatedVectorDrawable? = null
        fun bind(photo: Photo) {
            with(itemView) {
                tvCountLikes.text = context.resources.getString(R.string.likes_count).format(photo.likes)
                Glide.with(context).load(photo.user?.profileImage?.medium)
                    .error(R.drawable.ic_user_no_image)
                    .circleCrop()
                    .into(ivUserPhoto)
                ivPhoto.layoutParams.apply { height = photo.height?.div(5) ?: 200 }
                Glide.with(context)
                    .load(photo.urls?.regular)
                    .placeholder(R.drawable.ic_image_loading)
                    .error(R.drawable.ic_no_image)
                    .centerCrop()
                    .into(ivPhoto)
                tvUsername.text = photo.user?.username
                photo.description?.let {
                    val username = photo.user?.username
                    val userText = photo.description
                    val spannable: Spannable = SpannableString("$username $userText")
                    spannable.setSpan(
                        ForegroundColorSpan(Color.BLACK), 0, username?.length ?: 0,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    tvDescPhoto.setText(spannable, TextView.BufferType.SPANNABLE)
                    if (tvDescPhoto.lineCount > 2) {
                        val textWithMarker = context.resources.getString(R.string.more).format(spannable.lines()[0])
                        spannable.lines().forEachIndexed { index, s ->
                            if (index != 0) textWithMarker.plus(s)
                        }
                        tvDescPhoto.setText(textWithMarker, TextView.BufferType.SPANNABLE)
                    }
                } ?: run {
                    tvDescPhoto.text = "..."
                }
                ivContainer.setBackgroundColor(Color.parseColor(photo.color))
                if (photo.isFavorite) {
                    ivFavorite.setImageResource(R.drawable.ic_favorite_24)
                } else {
                    ivFavorite.setImageResource(R.drawable.ic_not_favorite_24_border)
                }
                ivFavorite.setOnClickListener {
                    photo.isFavorite = !photo.isFavorite
                    if (photo.isFavorite) {
                        ivFavorite.setImageResource(R.drawable.ic_favorite_24)
                        listener?.addToFavorite(photo)
                    } else {
                        ivFavorite.setImageResource(R.drawable.ic_not_favorite_24_border)
                        listener?.deleteFromFavorite(photo)
                    }
                }
                val doubleClick = DoubleClick(object : DoubleClickListener {

                    override fun onSingleClickEvent(view: View?) {
                    }

                    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                    override fun onDoubleClickEvent(view: View?) {
                        if (!photo.isFavorite) {
                            photo.isFavorite = true
                            ivFavorite.setImageResource(R.drawable.ic_favorite_24)
                            listener?.addToFavorite(photo)
                        }
                        ivLike.alpha = 0.70F
                        ivLike.makeVisible()
                        if (ivLike.drawable is AnimatedVectorDrawableCompat) {
                            avd = ivLike.drawable as AnimatedVectorDrawableCompat
                            avd?.start()
                        } else if (ivLike.drawable is AnimatedVectorDrawable) {
                            avd2 = ivLike.drawable as AnimatedVectorDrawable
                            avd2?.start()
                        }
                    }
                })
                ivShare.setOnClickListener {
                    val bitmap = (ivPhoto.drawable as BitmapDrawable).bitmap
                    listener?.onSharePhoto(photo, bitmap)
                }
                ivPhoto.setOnClickListener(doubleClick)
                rlUserData.setOnClickListener { listener?.onUserDataClick(photo) }
                ivUserPhoto.setOnClickListener { listener?.onUserDataClick(photo) }
                tvUsername.setOnClickListener { listener?.onUserDataClick(photo) }
                tvDescPhoto.setOnClickListener { tvDescPhoto.maxLines = Int.MAX_VALUE }
            }
        }
    }

    interface OnClickListener {
        fun addToFavorite(photo: Photo)
        fun deleteFromFavorite(photo: Photo)
        fun onUserDataClick(photo: Photo)
        fun onSharePhoto(photo: Photo, bitmap: Bitmap)
    }
}
