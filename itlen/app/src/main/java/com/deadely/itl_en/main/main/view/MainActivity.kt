package com.deadely.itl_en.main.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.deadely.itl_en.R
import com.deadely.itl_en.main.main.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
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
                when (position) {
                    0 -> bottom_navigation.menu.findItem(R.id.mnu_stats).isChecked = true
                    1 -> bottom_navigation.menu.findItem(R.id.mnu_study).isChecked = true
                    2 -> bottom_navigation.menu.findItem(R.id.mnu_vocab).isChecked = true
                }
            }
        })

//        val navController = Navigation.findNavController(this, R.id.nav_frag)
        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            if (!menuItem.isChecked) {
//                navController.navigate(menuItem.itemId)
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