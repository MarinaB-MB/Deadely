package com.deadely.itl_en.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.deadely.itl_en.R
import com.deadely.itl_en.ui.main.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var prevMenuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        vp_main.adapter = ViewPagerAdapter(supportFragmentManager)
        vp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null)
                    prevMenuItem?.isChecked = false;
                else
                    bottom_navigation.menu.getItem(0).isChecked = false;

                bottom_navigation.menu.getItem(position).isChecked = true;
                prevMenuItem = bottom_navigation.menu.getItem(position);
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            if (!menuItem.isChecked) {
                when (menuItem.itemId) {
                    R.id.mnu_stats -> vp_main.currentItem = 0
                    R.id.mnu_study -> vp_main.currentItem = 1
                    R.id.mnu_vocab -> vp_main.currentItem = 2
                }
            }
            true
        }
    }
}