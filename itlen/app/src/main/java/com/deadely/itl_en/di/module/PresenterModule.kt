package com.deadely.itl_en.di.module

import com.deadely.itl_en.ui.auth.IAuthContract
import com.deadely.itl_en.ui.auth.presenter.AuthPresenter
import com.deadely.itl_en.ui.lessonlist.ILessonsListContract
import com.deadely.itl_en.ui.lessonlist.presenter.LessonsListPresenter
import com.deadely.itl_en.ui.main.IMainContract
import com.deadely.itl_en.ui.main.presenter.MainPresenter
import com.deadely.itl_en.ui.reg.IRegContract
import com.deadely.itl_en.ui.reg.presenter.RegPresenter
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import com.deadely.itl_en.ui.splash.presenter.SplashScreenPresenter
import com.deadely.itl_en.ui.stat.IStatContract
import com.deadely.itl_en.ui.stat.presenter.StatPresenter
import com.deadely.itl_en.ui.study.IStudyContract
import com.deadely.itl_en.ui.study.presenter.StudyPresenter
import com.deadely.itl_en.ui.vocab.IVocabContract
import com.deadely.itl_en.ui.vocab.presenter.VocabPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindSplashScreenPresenter(presenter: SplashScreenPresenter?): ISplashScreenContract.Presenter?

    @Binds
    abstract fun bindAuthPresenter(presenter: AuthPresenter?): IAuthContract.Presenter?

    @Binds
    abstract fun bindRegPresenter(presenter: RegPresenter?): IRegContract.Presenter?

    @Binds
    abstract fun bindMainPresenter(presenter: MainPresenter?): IMainContract.Presenter?

    @Binds
    abstract fun bindStatPresenter(presenter: StatPresenter?): IStatContract.Presenter?

    @Binds
    abstract fun bindStudyPresenter(presenter: StudyPresenter?): IStudyContract.Presenter?

    @Binds
    abstract fun bindVocabPresenter(presenter: VocabPresenter?): IVocabContract.Presenter

    @Binds
    abstract fun bindLessonsListPresenter(presenter: LessonsListPresenter?): ILessonsListContract.Presenter?
}