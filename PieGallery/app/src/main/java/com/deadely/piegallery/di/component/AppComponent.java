package com.deadely.piegallery.di.component;

import com.deadely.piegallery.di.module.ActivityModule;
import com.deadely.piegallery.di.module.AppModule;
import com.deadely.piegallery.di.module.FragmentModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    ActivityComponent activityComponent(ActivityModule activityModule);
}
