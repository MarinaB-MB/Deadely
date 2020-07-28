package com.deadely.itl_en.main.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.deadely.itl_en.main.stat.view.StatFragment
import com.deadely.itl_en.main.study.view.StudyFragment
import com.deadely.itl_en.main.vocab.view.VocabFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter((fragmentManager!!)) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> StudyFragment()
            2 -> VocabFragment()
            else -> StatFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
