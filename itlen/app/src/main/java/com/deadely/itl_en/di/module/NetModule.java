package com.deadely.itl_en.di.module;

import com.deadely.itl_en.network.IRestDBService;
import com.deadely.itl_en.network.RestDBService;

import dagger.Module;
import dagger.Provides;
import kotlin.jvm.JvmStatic;

@Module
public class NetModule {
    @JvmStatic
    @Provides
    IRestDBService provideIRestDBService() {
        return new RestDBService().getClient();
    }
}
