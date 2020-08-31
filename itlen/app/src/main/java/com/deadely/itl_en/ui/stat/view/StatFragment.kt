package com.deadely.itl_en.ui.stat.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.deadely.itl_en.R
import com.deadely.itl_en.model.User
import com.deadely.itl_en.utils.Utils
import kotlinx.android.synthetic.main.fragment_stat.*


class StatFragment : Fragment(R.layout.fragment_stat) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }

    fun initData(lastStat: User.Stat) {
        val count: Int = lastStat.count_all
        val countSuccess: Int = lastStat.count_success
        val countFail: Int = lastStat.count_fail
        val date: String = Utils().formatDate(lastStat.date)

        tv_count_words.text = count.toString()
        tvCountSuccess.text = countSuccess.toString()

    }

    fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}