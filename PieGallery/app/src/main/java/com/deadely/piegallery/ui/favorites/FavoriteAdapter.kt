package com.deadely.piegallery.ui.favorites

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deadely.piegallery.R
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.utils.makeGone
import com.deadely.piegallery.utils.makeVisible
import kotlinx.android.synthetic.main.row_photo.view.*

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private var dataList = mutableListOf<Photo>()
    fun setData(list: List<Photo>) {
        dataList.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    private var listener: OnClickListener? = null
    fun setListener(clickListener: OnClickListener) {
        listener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false)
    )

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) = holder.bind(dataList[position])

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(photo: Photo) {
            with(itemView) {
//                ivPhoto.setImageBitmap(null)
                Glide.with(context)
                    .load(photo.urls?.regular)
                    .centerCrop()
                    .fitCenter()
                    .error(R.drawable.ic_no_image)
                    .into(ivPhoto)
                tvDescPhoto.text = photo.user?.username
                ivPhoto.setOnLongClickListener {
                    llDelete.makeVisible()
                    ivPhoto.makeGone()
                    tvDescPhoto.makeGone()
                    true
                }
                clContainer.setBackgroundColor(Color.parseColor(photo.color))
                llDelete.setOnClickListener { listener?.onDeleteClick(photo) }
                itemView.setOnClickListener { listener?.onDetailClick(photo) }
            }
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnClickListener {
        fun onDeleteClick(photo: Photo)
        fun onDetailClick(photo: Photo)
    }
}
