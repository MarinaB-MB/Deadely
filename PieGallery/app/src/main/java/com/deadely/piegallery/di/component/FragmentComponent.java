package com.deadely.piegallery.di.component;

import com.deadely.piegallery.di.PerFragment;
import com.deadely.piegallery.di.module.DatabaseModule;
import com.deadely.piegallery.di.module.FragmentModule;
import com.deadely.piegallery.di.module.NetModule;
import com.deadely.piegallery.di.module.PresenterModule;
import com.deadely.piegallery.view.favorites.view.FavoritesFragment;
import com.deadely.piegallery.view.info.view.InfoFragment;
import com.deadely.piegallery.view.photos.view.PhotosFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {FragmentModule.class, PresenterModule.class, DatabaseModule.class, NetModule.class})
public interface FragmentComponent {
    void inject(PhotosFragment fragment);

    void inject(FavoritesFragment fragment);

    void inject(InfoFragment fragment);

}
