package com.deadely.itl_en.ui.study.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deadely.itl_en.R
import com.deadely.itl_en.dataclasses.Group
import kotlinx.android.synthetic.main.row_group.view.*

class GroupAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    constructor(context: Context?, groupList: List<Group>) {
        this.context = context!!
        this.layoutInflater = LayoutInflater.from(context)
        this.groupList = groupList
    }

    private var groupList: List<Group>
    var context: Context
    var layoutInflater: LayoutInflater
    lateinit var onClickListener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = layoutInflater.inflate(R.layout.row_group, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val group: Group = groupList[position]

        holder.itemView.tvTitleGroup.text = group.title
        Glide.with(context)
                .load(group.image)
                .centerCrop()
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(holder.itemView.ivGroup)

        holder.itemView.setOnClickListener { if (onClickListener != null) onClickListener.onClick(group) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            val tvTitleGroup: TextView = view.findViewById(R.id.tvTitleGroup)
            val ivGroup: ImageView = view.findViewById(R.id.ivGroup)
        }
    }

    fun setData(list: List<Group>) {
        groupList = list
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(group: Group)
    }
}
