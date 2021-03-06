package com.deadely.itl_en.ui.vocab.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseFragment
import com.deadely.itl_en.dataclasses.Words
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.ui.study.GroupAdapter
import com.deadely.itl_en.ui.vocab.IVocabContract
import com.deadely.itl_en.ui.vocab.WordsAdapter
import kotlinx.android.synthetic.main.fragment_vocab.*
import javax.inject.Inject

class VocabFragment : BaseFragment(), IVocabContract.View {
    @Inject
    lateinit var presenter: IVocabContract.Presenter
    private lateinit var adapter: WordsAdapter
    private lateinit var list: MutableList<Words>

    private val WORD: String = "WORD"

    override fun inject(fragmentComponent: FragmentComponent?) {
        fragmentComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vocab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        rvWords.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter(context, emptyList())
        adapter.onClickListener = object : GroupAdapter.OnClickListener {
            override fun onClick(position: Int) {
//                val intent = Intent(context, WordDetailActivity::class.java)
//                intent.putExtra(WORD, list[position])
//                startActivity(intent)
            }
        }
        rvWords.adapter = adapter
        presenter.getWords()
    }

    override fun initData(list: MutableList<Words>) {
        this.list = list
        adapter.setData(list)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    }
}