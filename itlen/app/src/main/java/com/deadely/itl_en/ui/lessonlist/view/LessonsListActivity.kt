package com.deadely.itl_en.ui.lessonlist.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.itl_en.R
import com.deadely.itl_en.model.Group
import com.deadely.itl_en.ui.lessonlist.adapter.LessonsAdapter
import kotlinx.android.synthetic.main.activity_lessons_list.*

open class LessonsListActivity : AppCompatActivity(R.layout.activity_lessons_list) {
    private lateinit var adapter: LessonsAdapter
    lateinit var group: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons_list)
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
            override fun onClick(lesson: Group.Lesson) {

            }
        }
        rvLessonList.adapter = adapter
    }

    fun setData(list: List<Group.Lesson>) {
        adapter.setData(list)
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

