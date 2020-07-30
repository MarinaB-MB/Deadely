package com.deadely.itl_en.di.component;

import com.deadely.itl_en.di.module.ActivityModule;
import com.deadely.itl_en.di.module.NetModule;
import com.deadely.itl_en.di.module.PresenterModule;
import com.deadely.itl_en.ui.auth.view.AuthActivity;
import com.deadely.itl_en.ui.main.view.MainActivity;
import com.deadely.itl_en.ui.reg.view.RegActivity;
import com.deadely.itl_en.ui.splash.view.SplashScreenActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ActivityModule.class, PresenterModule.class, NetModule.class})
public interface ActivityComponent {
    void inject(SplashScreenActivity activity);

    void inject(AuthActivity activity);

    void inject(RegActivity activity);

    void inject(MainActivity activity);
}
