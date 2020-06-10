package com.deadely.piegallery.view.main;

import com.deadely.piegallery.base.IBaseMvpPresenter;
import com.deadely.piegallery.base.IBaseMvpView;

public interface IMainContract {
    interface View extends IBaseMvpView {
    }

    interface Presenter extends IBaseMvpPresenter<View> {
    }

}
