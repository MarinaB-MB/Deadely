package com.deadely.itl_en.ui.study.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.model.Group
import com.deadely.itl_en.ui.lessonlist.view.LessonsListActivity
import com.deadely.itl_en.ui.study.adapter.GroupAdapter
import kotlinx.android.synthetic.main.fragment_study.*

class StudyFragment : Fragment(R.layout.fragment_study) {
    private lateinit var adapter: GroupAdapter
    private lateinit var list: MutableList<Group>
    private val GROUP: String = "GROUP"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        rvGroups.layoutManager = GridLayoutManager(context, 2)
        adapter = GroupAdapter(context, emptyList())
        adapter.onClickListener = object : GroupAdapter.OnClickListener {
            override fun onClick(group: Group) {

            }
        }
        rvGroups.adapter = adapter
    }

    fun initData(list: MutableList<Group>) {
        this.list = list
        adapter.setData(list)
    }

    fun showGroupScreen(group: Group) {
        val intent = Intent(context, LessonsListActivity::class.java)
        intent.putExtra(GROUP, group)
        startActivity(intent)
    }

    fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}