package com.deadely.piegallery.di.module;

import com.deadely.piegallery.network.APIclient;
import com.deadely.piegallery.network.APIinterface;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {
    @Provides
    APIinterface getApiInterface() {
        return new APIclient().apIinterface();
    }

}
