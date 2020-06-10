package com.deadely.piegallery.view.photos.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.deadely.piegallery.R;
import com.deadely.piegallery.base.BaseFragment;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.di.component.FragmentComponent;
import com.deadely.piegallery.view.detailphoto.view.DetailPhotoActivity;
import com.deadely.piegallery.view.photos.IPhotosContract;
import com.deadely.piegallery.view.photos.PhotoAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class PhotosFragment extends BaseFragment implements IPhotosContract.View, PhotoAdapter.OnClickListener {
    public static String ID = "photo_id";

    private List<Photo> mPhotoResponse;
    private PhotoAdapter photoAdapter;
    @Inject
    public IPhotosContract.Presenter photosPresenter;
    private Unbinder unbinder;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.rv_photo_list)
    RecyclerView rvPhotoList;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.tv_status)
    TextView tvStatus;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_photos, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        photosPresenter.attachView(this);

        GridLayoutManager LayoutManager = new GridLayoutManager(getContext(), 2);
        rvPhotoList.setLayoutManager(LayoutManager);
        photoAdapter = new PhotoAdapter(getContext());
        photoAdapter.setOnClickListener(this);
        getPhotoList();
        rvPhotoList.setAdapter(photoAdapter);

        swipeRefresh.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            swipeRefresh.setRefreshing(false);
            getPhotoList();
        }, 1000));
    }

    @Override
    public void showProgress() {
        rvPhotoList.setVisibility(GONE);
        tvStatus.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        rvPhotoList.setVisibility(VISIBLE);
        tvStatus.setVisibility(GONE);
        progressBar.setVisibility(GONE);
    }

    private void getPhotoList() {
        photosPresenter.showProgressBar();
        photosPresenter.getPhotoList();
    }

    @Override
    public void setPhotoList(List<Photo> list) {
        mPhotoResponse = list;
        photoAdapter.setData(mPhotoResponse);

        photosPresenter.hideProgressBar();
    }

    @Override
    public void showErrorConn(String errorMessage) {
        rvPhotoList.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        tvStatus.setVisibility(VISIBLE);
        tvStatus.setText(errorMessage);
    }

    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(getActivity(), DetailPhotoActivity.class);
        intent.putExtra(ID, mPhotoResponse.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        photosPresenter.detachView();
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}