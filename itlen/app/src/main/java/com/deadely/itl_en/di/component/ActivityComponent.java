package com.deadely.itl_en.di.component;

import com.deadely.itl_en.di.module.ActivityModule;
import com.deadely.itl_en.di.module.PresenterModule;
import com.deadely.itl_en.ui.splash.view.SplashScreenActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, PresenterModule.class})
public interface ActivityComponent {
    void inject(SplashScreenActivity splashScreenActivity);
}
