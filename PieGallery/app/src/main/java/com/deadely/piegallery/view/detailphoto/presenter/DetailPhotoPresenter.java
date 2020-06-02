package com.deadely.piegallery.view.detailphoto.presenter;

import com.deadely.piegallery.App;
import com.deadely.piegallery.R;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.dataclasses.Favorites;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.network.APIclient;
import com.deadely.piegallery.network.APIinterface;
import com.deadely.piegallery.view.detailphoto.IDetailPhotoContract;
import com.deadely.piegallery.view.detailphoto.view.DetailPhotoActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPhotoPresenter implements IDetailPhotoContract.IPresenter {
    private static String TAG = "GET Photo";
    private DetailPhotoActivity detailPhotoActivity;
    private AppDBHelper db;

    private APIinterface apiInterface;

    public DetailPhotoPresenter(DetailPhotoActivity detailPhotoActivity) {
        this.detailPhotoActivity = detailPhotoActivity;
        db = App.getInstance().getDatabaseInstance();
    }

    @Override
    public void showProgressBar() {
        detailPhotoActivity.showProgress();
    }

    @Override
    public void hideProgressBar() {
        detailPhotoActivity.hideProgress();
    }

    @Override
    public void deleteElement(String id) {
        if (db.getFavoritesDao().getAllFavorites().size() == 0) {
            detailPhotoActivity.addToFavorite(R.string.fav_list_is_empty);
        } else {
            Favorites favorites = db.getFavoritesDao().findByPhotoId(id);
            if (favorites != null) {
                db.getFavoritesDao().deleteByPhotoId(id);
                detailPhotoActivity.addToFavorite(R.string.deleted_from_fav);
            } else {
                detailPhotoActivity.addToFavorite(R.string.dont_exist);
            }
        }
    }

    @Override
    public void addElement(String id) {
        if (db.getFavoritesDao().getAllFavorites().size() == 0) {
            db.getFavoritesDao().insert(new Favorites(db.getPhotoDao().getById(id)));
            String.valueOf(R.string.add_to_fav);
            detailPhotoActivity.addToFavorite(R.string.add_to_fav);
        } else {
            Favorites favorites = db.getFavoritesDao().findByPhotoId(id);
            if (favorites != null) {
                String.valueOf(R.string.already_exist);
                detailPhotoActivity.addToFavorite(R.string.already_exist);
            } else {
                db.getFavoritesDao().insert(new Favorites(db.getPhotoDao().getById(id)));
                detailPhotoActivity.addToFavorite(R.string.add_to_fav);
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
                        detailPhotoActivity.setPhoto(photo);
                    } else {
                        detailPhotoActivity.showErrorConn(String.valueOf(R.string.error));
                    }
                } else {
                    detailPhotoActivity.showErrorConn(String.valueOf(R.string.error));
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                detailPhotoActivity.showErrorConn(String.valueOf(R.string.check_connection));
            }
        });

    }
}
