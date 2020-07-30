package com.deadely.itl_en.di.module

import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.network.RestDBService
import dagger.Module
import dagger.Provides

@Module
class NetModule {
    @Provides
    fun provideIRestDBService(): IRestDBService {
        return RestDBService().getClient()
    }
}