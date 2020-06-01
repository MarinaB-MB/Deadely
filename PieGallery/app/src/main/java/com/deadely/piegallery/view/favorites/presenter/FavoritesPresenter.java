package com.deadely.piegallery.view.favorites.presenter;

import com.deadely.piegallery.App;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.database.dao.FavoritesDao;
import com.deadely.piegallery.view.favorites.IFavoritesContract;
import com.deadely.piegallery.view.favorites.view.FavoritesFragment;

public class FavoritesPresenter implements IFavoritesContract.IPresenter {

    private FavoritesFragment fragment;

    public FavoritesPresenter(FavoritesFragment favoritesFragment) {
        this.fragment = favoritesFragment;
    }

    @Override
    public void showProgressBar() {
        fragment.showProgress();
    }

    @Override
    public void hideProgressBar() {
        fragment.hideProgress();
    }

    @Override
    public void clearList() {
        AppDBHelper db = App.getInstance().getDatabaseInstance();
        db.getFavoritesDao().deleteAll();

        getPhotoList();
    }

    @Override
    public void getPhotoList() {
        AppDBHelper db = App.getInstance().getDatabaseInstance();
        FavoritesDao favoritesDao = db.getFavoritesDao();

        if (favoritesDao.getAllFavorites().size() == 0) {
            fragment.setEmptyList();
        } else {
            fragment.setPhotoList(favoritesDao.getAllFavorites());
        }
    }
}