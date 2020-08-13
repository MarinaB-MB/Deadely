package com.deadely.itl_en.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.deadely.itl_en.ui.stat.view.StatFragment
import com.deadely.itl_en.ui.study.view.StudyFragment
import com.deadely.itl_en.ui.vocab.view.VocabFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter((fragmentManager)) {

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
