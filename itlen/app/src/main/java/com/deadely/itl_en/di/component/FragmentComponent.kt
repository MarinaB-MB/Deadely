package com.deadely.itl_en.di.component

import com.deadely.itl_en.di.module.DatabaseModule
import com.deadely.itl_en.di.module.FragmentModule
import com.deadely.itl_en.di.module.NetModule
import com.deadely.itl_en.di.module.PresenterModule
import com.deadely.itl_en.ui.stat.view.StatFragment
import com.deadely.itl_en.ui.study.view.StudyFragment
import com.deadely.itl_en.ui.vocab.view.VocabFragment
import dagger.Subcomponent

@Subcomponent(modules = [FragmentModule::class, PresenterModule::class, NetModule::class, DatabaseModule::class])
interface FragmentComponent {
    fun inject(fragment: StatFragment?)
    fun inject(fragment: StudyFragment?)
    fun inject(fragment: VocabFragment?)
}