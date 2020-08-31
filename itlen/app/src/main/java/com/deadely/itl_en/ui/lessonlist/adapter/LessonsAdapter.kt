package com.deadely.itl_en.ui.lessonlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deadely.itl_en.R
import com.deadely.itl_en.model.Group
import kotlinx.android.synthetic.main.row_lesson.view.*

class LessonsAdapter(context: Context?, private var list: List<Group.Lesson>) : RecyclerView.Adapter<LessonsAdapter.ViewHolder>() {

    var context = context!!
    var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    lateinit var onClickListener: OnClickListener


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            val tvTitleLesson = view.findViewById<TextView>(R.id.tvLessonTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(layoutInflater.inflate(R.layout.row_lesson, parent, false))
    override fun getItemCount(): Int = list.let { list.size }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lesson = list[position]
        holder.itemView.tvLessonTitle.text = lesson.title
        holder.itemView.setOnClickListener { onClickListener.let { onClickListener.onClick(lesson) } }
    }

    fun setData(list: List<Group.Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(lesson: Group.Lesson)
    }
}
