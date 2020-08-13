package com.deadely.itl_en.ui.vocab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deadely.itl_en.R
import com.deadely.itl_en.dataclasses.Words
import kotlinx.android.synthetic.main.row_word.view.*

class WordsAdapter(context: Context?, private var wordList: List<Words>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context: Context = context!!
    var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    lateinit var onClickListener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = layoutInflater.inflate(R.layout.row_word, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val words = wordList[position]
        holder.itemView.tvWord.text = words.word
        holder.itemView.setOnClickListener { if (onClickListener != null) onClickListener.onClick(words) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            val tvWord: TextView = view.findViewById(R.id.tvWord)
        }
    }


    fun setData(list: List<Words>) {
        wordList = list
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(word: Words)
    }
}