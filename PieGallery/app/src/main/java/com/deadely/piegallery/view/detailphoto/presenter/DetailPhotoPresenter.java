package com.deadely.piegallery.view.detailphoto.presenter;

import com.deadely.piegallery.App;
import com.deadely.piegallery.R;
import com.deadely.piegallery.base.BasePresenter;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.dataclasses.Favorites;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.network.APIclient;
import com.deadely.piegallery.network.APIinterface;
import com.deadely.piegallery.view.detailphoto.IDetailPhotoContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPhotoPresenter extends BasePresenter<IDetailPhotoContract.View> implements IDetailPhotoContract.Presenter {
    private AppDBHelper db;

    private APIinterface apiInterface;

    @Inject
    public DetailPhotoPresenter() {
        db = App.getInstance().getDatabaseInstance();
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
    public void deleteElement(String id) {
        if (db.getFavoritesDao().getAllFavorites().size() == 0) {
            getMvpView().addToFavorite(R.string.fav_list_is_empty);
        } else {
            Favorites favorites = db.getFavoritesDao().findByPhotoId(id);
            if (favorites != null) {
                db.getFavoritesDao().deleteByPhotoId(id);
                getMvpView().addToFavorite(R.string.deleted_from_fav);
            } else {
                getMvpView().addToFavorite(R.string.dont_exist);
            }
        }
    }

    @Override
    public void addElement(String id) {
        if (db.getFavoritesDao().getAllFavorites().size() == 0) {
            db.getFavoritesDao().insert(new Favorites(db.getPhotoDao().getById(id)));
            String.valueOf(R.string.add_to_fav);
            getMvpView().addToFavorite(R.string.add_to_fav);
        } else {
            Favorites favorites = db.getFavoritesDao().findByPhotoId(id);
            if (favorites != null) {
                String.valueOf(R.string.already_exist);
                getMvpView().addToFavorite(R.string.already_exist);
            } else {
                db.getFavoritesDao().insert(new Favorites(db.getPhotoDao().getById(id)));
                getMvpView().addToFavorite(R.string.add_to_fav);
            }
        }
    }

    @Override
    public void getPhoto(String id) {
        apiInterface = new APIclient().apIinterface();
        Call<Photo> call = apiInterface.getPhoto(id, 150, 150);
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()) {
                    Photo photo = response.body();
                    if (photo != null) {
                        getMvpView().setPhoto(photo);
                    } else {
                        getMvpView().showErrorConn(String.valueOf(R.string.error));
                    }
                } else {
                    getMvpView().showErrorConn(String.valueOf(R.string.error));
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                getMvpView().showErrorConn(String.valueOf(R.string.check_connection));
            }
        });

    }
}
