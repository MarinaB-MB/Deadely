package com.deadely.piegallery.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.deadely.piegallery.database.dao.FavoritesDao;
import com.deadely.piegallery.database.dao.LinksDao;
import com.deadely.piegallery.database.dao.Links_Dao;
import com.deadely.piegallery.database.dao.PhotoDao;
import com.deadely.piegallery.database.dao.Profile_ImagesDao;
import com.deadely.piegallery.database.dao.SponsorDao;
import com.deadely.piegallery.database.dao.SponsorshipDao;
import com.deadely.piegallery.database.dao.UrlsDao;
import com.deadely.piegallery.database.dao.UserDao;
import com.deadely.piegallery.dataclasses.Favorites;
import com.deadely.piegallery.dataclasses.Links;
import com.deadely.piegallery.dataclasses.Links_2;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.dataclasses.Profile_Image;
import com.deadely.piegallery.dataclasses.Sponsor;
import com.deadely.piegallery.dataclasses.Sponsorship;
import com.deadely.piegallery.dataclasses.Urls;
import com.deadely.piegallery.dataclasses.User;

@Database(entities = {Photo.class, User.class, Urls.class, Links.class, Links_2.class, Profile_Image.class, Favorites.class, Sponsor.class, Sponsorship.class},
        version = 1, exportSchema = false)
@TypeConverters({StringConverter.class, PhotoConverter.class})
public abstract class AppDBHelper extends RoomDatabase {

    public abstract UserDao getUserDao();

    public abstract UrlsDao getUrlsDao();

    public abstract Links_Dao getLinks_Dao();

    public abstract LinksDao getLinksDao();

    public abstract Profile_ImagesDao getProfile_ImagesDao();

    public abstract SponsorDao getSponsorDao();

    public abstract SponsorshipDao getSponsorshipDao();

    public abstract PhotoDao getPhotoDao();

    public abstract FavoritesDao getFavoritesDao();


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {


    }

}