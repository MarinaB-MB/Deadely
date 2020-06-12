package com.deadely.piegallery.di.module;

import com.deadely.piegallery.App;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.database.dao.FavoritesDao;
import com.deadely.piegallery.database.dao.PhotoDao;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    AppDBHelper getDBIntance() {
        return App.getInstance().getDatabaseInstance();
    }

    @Provides
    FavoritesDao getFavDAO() {
        return App.getInstance().getDatabaseInstance().getFavoritesDao();
    }

    @Provides
    PhotoDao getPhotoDAO() {
        return App.getInstance().getDatabaseInstance().getPhotoDao();
    }
}
