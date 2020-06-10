package com.deadely.piegallery.view.info;

import com.deadely.piegallery.base.IBaseMvpPresenter;
import com.deadely.piegallery.base.IBaseMvpView;

public interface IInfoContract {
    interface View extends IBaseMvpView {
    }

    interface Presenter extends IBaseMvpPresenter<View> {
    }

}
