package com.deadely.itl_en.ui.stat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseFragment
import com.deadely.itl_en.dataclasses.Stat
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.ui.stat.IStatContract
import kotlinx.android.synthetic.main.fragment_stat.*
import javax.inject.Inject


class StatFragment : BaseFragment(), IStatContract.View {
    @Inject
    lateinit var presenter: IStatContract.Presenter

    override fun inject(fragmentComponent: FragmentComponent?) {
        fragmentComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stat, container, false)
    }

    private fun initView() {
        presenter.getStat()
    }

    override fun initData(list: MutableList<Stat>) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun startLoading() {
        super.startLoading()
        rlStatContent.visibility = GONE
        pvLoad.visibility = VISIBLE
        rlErrorContainer.visibility = GONE
    }

    override fun completeLoading() {
        super.completeLoading()
        rlStatContent.visibility = VISIBLE
        pvLoad.visibility = GONE
        rlErrorContainer.visibility = GONE
    }

    override fun errorLoading() {
        super.errorLoading()
        rlStatContent.visibility = GONE
        pvLoad.visibility = GONE
        rlErrorContainer.visibility = VISIBLE
    }

    override fun showMessage(msg: String) {

    }
}