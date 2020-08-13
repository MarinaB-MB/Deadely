package com.deadely.itl_en.ui.study.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseFragment
import com.deadely.itl_en.dataclasses.Group
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.ui.lessonlist.view.LessonsListActivity
import com.deadely.itl_en.ui.study.IStudyContract
import com.deadely.itl_en.ui.study.adapter.GroupAdapter
import kotlinx.android.synthetic.main.fragment_study.*
import javax.inject.Inject

class StudyFragment : BaseFragment(), IStudyContract.View {
    private lateinit var adapter: GroupAdapter
    private lateinit var list: MutableList<Group>
    private val GROUP: String = "GROUP"

    @Inject
    lateinit var presenter: IStudyContract.Presenter

    override fun inject(fragmentComponent: FragmentComponent?) {
        fragmentComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_study, container, false)
    }

    private fun initView() {
        rvGroups.layoutManager = GridLayoutManager(context, 2)
        adapter = GroupAdapter(context, emptyList())
        adapter.onClickListener = object : GroupAdapter.OnClickListener {
            override fun onClick(group: Group) {
                presenter.openGroupScreen(group)
            }
        }
        rvGroups.adapter = adapter
        presenter.getGroup()
    }

    override fun initData(list: MutableList<Group>) {
        this.list = list
        adapter.setData(list)
    }

    override fun showGroupScreen(group: Group) {
        val intent = Intent(context, LessonsListActivity::class.java)
        intent.putExtra(GROUP, group)
        startActivity(intent)
    }

    override fun startLoading() {
        super.startLoading()
        rlStudyContent.visibility = View.GONE
        pvLoad.visibility = View.VISIBLE
        rlErrorContainer.visibility = View.GONE
    }

    override fun completeLoading() {
        super.completeLoading()
        rlStudyContent.visibility = View.VISIBLE
        pvLoad.visibility = View.GONE
        rlErrorContainer.visibility = View.GONE
    }

    override fun errorLoading() {
        super.errorLoading()
        rlStudyContent.visibility = View.GONE
        pvLoad.visibility = View.GONE
        rlErrorContainer.visibility = View.VISIBLE
    }


    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}