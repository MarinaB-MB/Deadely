package com.deadely.piegallery.view.main.presenter;

import com.deadely.piegallery.view.main.IMainContract;
import com.deadely.piegallery.view.main.view.MainActivity;


public class MainPresenter implements IMainContract.IPresenter {
    private MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
    }

}
