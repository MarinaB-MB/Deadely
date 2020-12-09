package com.deadely.piegallery.navigation

import android.content.Intent
import com.deadely.piegallery.ui.favorites.view.FavoritesFragment
import com.deadely.piegallery.ui.info.view.InfoFragment
import com.deadely.piegallery.ui.main.view.MainActivity
import com.deadely.piegallery.ui.photos.view.PhotosFragment
import com.deadely.piegallery.ui.splash.SplashActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun MainScreen() = ActivityScreen { Intent(it, MainActivity::class.java) }
    fun SplashScreen() = ActivityScreen { Intent(it, SplashActivity::class.java) }
    fun PhotosScreen() = FragmentScreen { PhotosFragment() }
    fun InfoScreen() = FragmentScreen { InfoFragment() }
    fun FavoritesScreen() = FragmentScreen { FavoritesFragment() }
}
