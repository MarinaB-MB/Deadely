package com.deadely.itl_en.ui.vocab.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.model.Group
import com.deadely.itl_en.ui.vocab.adapter.WordsAdapter
import kotlinx.android.synthetic.main.fragment_vocab.*
import kotlinx.android.synthetic.main.layout_search.*

class VocabFragment : Fragment(R.layout.fragment_vocab) {
    private lateinit var adapter: WordsAdapter
    private lateinit var list: MutableList<Group.Lesson.Word>

    private val WORD: String = "WORD"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        rvWords.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter(context, emptyList())
        adapter.onClickListener = object : WordsAdapter.OnClickListener {
            override fun onClick(words: Group.Lesson.Word) {

            }
        }
        rvWords.adapter = adapter

        etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) searchWord(etSearch.text.toString())
            false
        }
        ivClose.setOnClickListener { etSearch.text.clear() }
    }

    private fun searchWord(string: String) {

    }

    fun initData(list: MutableList<Group.Lesson.Word>) {
        this.list = list
        adapter.setData(list)
    }

    fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}