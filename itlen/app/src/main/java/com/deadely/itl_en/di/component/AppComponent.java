package com.deadely.itl_en.di.component;

import com.deadely.itl_en.di.module.ActivityModule;
import com.deadely.itl_en.di.module.AppModule;
import com.deadely.itl_en.di.module.FragmentModule;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModuke);
}
