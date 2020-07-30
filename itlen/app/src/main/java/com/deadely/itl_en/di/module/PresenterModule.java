package com.deadely.itl_en.di.module;

import com.deadely.itl_en.ui.auth.IAuthContract;
import com.deadely.itl_en.ui.auth.presenter.AuthPresenter;
import com.deadely.itl_en.ui.main.IMainContract;
import com.deadely.itl_en.ui.main.presenter.MainPresenter;
import com.deadely.itl_en.ui.reg.IRegContract;
import com.deadely.itl_en.ui.reg.presenter.RegPresenter;
import com.deadely.itl_en.ui.splash.ISplashScreenContract;
import com.deadely.itl_en.ui.splash.presenter.SplashScreenPresenter;
import com.deadely.itl_en.ui.stat.IStatContract;
import com.deadely.itl_en.ui.stat.presenter.StatPresenter;
import com.deadely.itl_en.ui.study.IStudyContract;
import com.deadely.itl_en.ui.study.presenter.StudyPresenter;
import com.deadely.itl_en.ui.vocab.IVocabContract;
import com.deadely.itl_en.ui.vocab.presenter.VocabPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {
    @Binds
    abstract ISplashScreenContract.Presenter bindSplashScreenPresenter(SplashScreenPresenter presenter);

    @Binds
    abstract IAuthContract.Presenter bindAuthPresenter(AuthPresenter presenter);

    @Binds
    abstract IRegContract.Presenter bindRegPresenter(RegPresenter presenter);

    @Binds
    abstract IMainContract.Presenter bindMainPresenter(MainPresenter presenter);

    @Binds
    abstract IStatContract.Presenter bindStatPresenter(StatPresenter presenter);

    @Binds
    abstract IStudyContract.Presenter bindStudyPresenter(StudyPresenter presenter);

    @Binds
    abstract IVocabContract.Presenter bindVocabPresenter(VocabPresenter presenter);

}

