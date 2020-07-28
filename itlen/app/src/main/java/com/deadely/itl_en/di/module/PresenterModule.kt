package com.deadely.itl_en.di.module

import com.deadely.itl_en.main.auth.IAuthContract
import com.deadely.itl_en.main.auth.presenter.AuthPresenter
import com.deadely.itl_en.main.main.IMainContract
import com.deadely.itl_en.main.main.presenter.MainPresenter
import com.deadely.itl_en.main.reg.IRegContract
import com.deadely.itl_en.main.reg.presenter.RegPresenter
import com.deadely.itl_en.main.stat.IStatContract
import com.deadely.itl_en.main.stat.presenter.StatPresenter
import com.deadely.itl_en.main.study.IStudyContract
import com.deadely.itl_en.main.study.presenter.StudyPresenter
import com.deadely.itl_en.main.vocab.IVocabContract
import com.deadely.itl_en.main.vocab.presenter.VocabPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindStatPresenter(presenter: StatPresenter): IStatContract.Presenter

    @Binds
    abstract fun bindStudyPresenter(presenter: StudyPresenter): IStudyContract.Presenter

    @Binds
    abstract fun bindVocabPresenter(presenter: VocabPresenter): IVocabContract.Presenter


    @Binds
    abstract fun bindMainPresenter(presenter: MainPresenter): IMainContract.Presenter

    @Binds
    abstract fun bindAuthPresenter(presenter: AuthPresenter): IAuthContract.Presenter

    @Binds
    abstract fun bindRegPresenter(presenter: RegPresenter): IRegContract.Presenter

}