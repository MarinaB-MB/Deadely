package com.deadely.itl_en.ui.lessonlist.view

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.dataclasses.Group
import com.deadely.itl_en.dataclasses.Lesson
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.lessonlist.ILessonsListContract
import com.deadely.itl_en.ui.lessonlist.adapter.LessonsAdapter
import kotlinx.android.synthetic.main.activity_lessons_list.*
import javax.inject.Inject

open class LessonsListActivity : BaseActivity(), ILessonsListContract.View {
    @Inject
    lateinit var presenter: ILessonsListContract.Presenter

    private lateinit var adapter: LessonsAdapter
    lateinit var group: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_list)
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        getExtras()
        initView()
    }

    private fun getExtras() {
        group = intent.extras?.getParcelable("GROUP")!!
    }

    private fun initView() {
        rvLessonList.layoutManager = LinearLayoutManager(this)
        adapter = LessonsAdapter(this, emptyList())
        adapter.onClickListener = object : LessonsAdapter.OnClickListener {
            override fun onClick(lesson: Lesson) {

            }
        }
        rvLessonList.adapter = adapter
        presenter.getLessonsListByGroup(group._id)

    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setData(list: List<Lesson>) {
        adapter.setData(list)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

