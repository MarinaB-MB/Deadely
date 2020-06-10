package com.deadely.piegallery.view.main.presenter;

import com.deadely.piegallery.base.BasePresenter;
import com.deadely.piegallery.view.main.IMainContract;

import javax.inject.Inject;


public class MainPresenter extends BasePresenter<IMainContract.View> implements IMainContract.Presenter {
    @Inject
    public MainPresenter() {
    }
}
