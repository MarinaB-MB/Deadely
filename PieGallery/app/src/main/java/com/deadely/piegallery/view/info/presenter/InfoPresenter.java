package com.deadely.piegallery.view.info.presenter;

import com.deadely.piegallery.base.BasePresenter;
import com.deadely.piegallery.view.info.IInfoContract;

import javax.inject.Inject;

public class InfoPresenter extends BasePresenter<IInfoContract.View> implements IInfoContract.Presenter {
    @Inject
    public InfoPresenter() {
    }
}
