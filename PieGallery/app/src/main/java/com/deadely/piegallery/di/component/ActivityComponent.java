package com.deadely.piegallery.di.component;

import com.deadely.piegallery.di.PerActivity;
import com.deadely.piegallery.di.module.ActivityModule;
import com.deadely.piegallery.di.module.PresenterModule;
import com.deadely.piegallery.view.detailphoto.view.DetailPhotoActivity;
import com.deadely.piegallery.view.main.view.MainActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {PresenterModule.class, ActivityModule.class})
public interface ActivityComponent {

    void inject(DetailPhotoActivity photoActivity);

    void inject(MainActivity mainActivity);
}
