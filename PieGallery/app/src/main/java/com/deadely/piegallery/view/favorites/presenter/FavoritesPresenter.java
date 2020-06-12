package com.deadely.piegallery.view.favorites.presenter;

import com.deadely.piegallery.App;
import com.deadely.piegallery.base.BasePresenter;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.database.dao.FavoritesDao;
import com.deadely.piegallery.view.favorites.IFavoritesContract;

import javax.inject.Inject;

public class FavoritesPresenter extends BasePresenter<IFavoritesContract.View> implements IFavoritesContract.Presenter {
    private FavoritesDao favoritesDao;
    private AppDBHelper db;

    @Inject
    public FavoritesPresenter(FavoritesDao favoritesDao, AppDBHelper db) {
        this.favoritesDao = favoritesDao;
        this.db = db;
    }

    @Override
    public void showProgressBar() {
        getMvpView().showProgress();
    }

    @Override
    public void hideProgressBar() {
        getMvpView().hideProgress();
    }

    @Override
    public void clearList() {
        AppDBHelper db = App.getInstance().getDatabaseInstance();
        db.getFavoritesDao().deleteAll();

        getPhotoList();
    }

    @Override
    public void getPhotoList() {
        if (favoritesDao.getAllFavorites().size() == 0) {
            getMvpView().setEmptyList();
        } else {
            getMvpView().setPhotoList(favoritesDao.getAllFavorites());
        }
    }
}