package com.deadely.itl_en.di.component;


import com.deadely.itl_en.di.PerActivity;
import com.deadely.itl_en.di.module.ActivityModule;
import com.deadely.itl_en.di.module.DatabaseModule;
import com.deadely.itl_en.di.module.NetModule;
import com.deadely.itl_en.di.module.PresenterModule;
import com.deadely.itl_en.main.auth.view.AuthActivity;
import com.deadely.itl_en.main.main.view.MainActivity;
import com.deadely.itl_en.main.reg.view.RegActivity;
import com.deadely.itl_en.main.splash.view.SplashScreenActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {PresenterModule.class, ActivityModule.class, DatabaseModule.class, NetModule.class})
public interface ActivityComponent {

    void inject(SplashScreenActivity photoActivity);

    void inject(MainActivity mainActivity);

    void inject(RegActivity mainActivity);

    void inject(AuthActivity mainActivity);
}
