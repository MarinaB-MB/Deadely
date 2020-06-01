package com.deadely.piegallery.view.photos.presenter;

import com.deadely.piegallery.App;
import com.deadely.piegallery.R;
import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.network.APIclient;
import com.deadely.piegallery.network.APIinterface;
import com.deadely.piegallery.view.photos.IPhotosContract;
import com.deadely.piegallery.view.photos.view.PhotosFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosPresenter implements IPhotosContract.IPresenter {

    private static final String LATEST = "latest";
    private List<Photo> mPhotoList;
    private PhotosFragment photosFragment;

    private AppDBHelper db;

    public PhotosPresenter(PhotosFragment photosFragment) {
        this.photosFragment = photosFragment;
    }

    @Override
    public void refreshData() {
        getRequest();
    }

    @Override
    public void getPhotoList() {
        db = App.getInstance().getDatabaseInstance();
        mPhotoList = db.getPhotoDao().getAllPhotos();
        if (mPhotoList.size() != 0) {
            photosFragment.setPhotoList(mPhotoList);
        } else {
            getRequest();
        }
    }

    private void getRequest() {
        db = App.getInstance().getDatabaseInstance();
        db.getPhotoDao().deleteAll();
        db.getFavoritesDao().deleteAll();

        APIinterface apIinterface = new APIclient().apIinterface();
        Call<List<Photo>> call = apIinterface.getPhotos(1, 50, LATEST);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()) {
                    mPhotoList = response.body();
                    assert mPhotoList != null;
                    for (int i = 0; i < mPhotoList.size(); i++) {
                        db.getPhotoDao().insert(mPhotoList.get(i));
                    }
                    photosFragment.setPhotoList(db.getPhotoDao().getAllPhotos());
                } else {
                    photosFragment.showErrorConn(String.valueOf(R.string.error));
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                photosFragment.showErrorConn(String.valueOf(R.string.check_connection));
            }
        });
    }

    @Override
    public void showProgressBar() {
        photosFragment.showProgress();
    }

    @Override
    public void hideProgressBar() {
        photosFragment.hideProgress();
    }
}
