package com.deadely.itl_en.ui.vocab.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseFragment
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.ui.vocab.IVocabContract
import javax.inject.Inject

class VocabFragment : BaseFragment(), IVocabContract.View {
    @Inject
    lateinit var presenter: IVocabContract.Presenter
    override fun inject(fragmentComponent: FragmentComponent?) {
        fragmentComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vocab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    }
}