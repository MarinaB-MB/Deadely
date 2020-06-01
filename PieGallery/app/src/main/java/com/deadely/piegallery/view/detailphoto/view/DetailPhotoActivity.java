package com.deadely.piegallery.view.detailphoto.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.deadely.piegallery.R;
import com.deadely.piegallery.dataclasses.Photo;
import com.deadely.piegallery.view.detailphoto.IDetailPhotoContract;
import com.deadely.piegallery.view.detailphoto.presenter.DetailPhotoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.deadely.piegallery.view.photos.view.PhotosFragment.ID;

public class DetailPhotoActivity extends AppCompatActivity implements IDetailPhotoContract.IView {
    @BindView(R.id.iv_detail_photo)
    ImageView ivDetailPhoto;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_count_likes)
    TextView tvCountLikes;
    @BindView(R.id.cl_content)
    ConstraintLayout clContent;
    @BindView(R.id.pb_detail)
    ProgressBar pbDetail;
    @BindView(R.id.tv_status)
    TextView tvStatus;

    private String id;
    private DetailPhotoPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_detailphoto);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            id = getIntent().getExtras().getString(ID);
        }
        presenter = new DetailPhotoPresenter(this);
        getData();

    }

    private void getData() {
        presenter.showProgressBar();
        presenter.getPhoto(id);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.mnu_add:
                presenter.addElement(id);
                return true;
            case R.id.mnu_delete:
                presenter.deleteElement(id);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite_menu, menu);
        return true;
    }

    @Override
    public void addToFavorite(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteFromFavorite(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        clContent.setVisibility(GONE);
        pbDetail.setVisibility(VISIBLE);
        tvStatus.setVisibility(GONE);
    }

    @Override
    public void showErrorConn(String errorMessage) {
        clContent.setVisibility(GONE);
        pbDetail.setVisibility(GONE);
        tvStatus.setVisibility(VISIBLE);
        tvStatus.setText(errorMessage);
    }

    @Override
    public void hideProgress() {
        tvStatus.setVisibility(GONE);
        clContent.setVisibility(VISIBLE);
        pbDetail.setVisibility(GONE);
    }

    @Override
    public void setPhoto(Photo photo) {
        Glide.with(getApplicationContext()).load(photo.getUrls().getFull()).error(R.drawable.ic_launcher_background).into(ivDetailPhoto);
        ivDetailPhoto.setBackgroundColor(Color.parseColor(photo.getColor()));
        tvUsername.setText("By " + photo.getUser().getUsername());
        tvDesc.setText(photo.getDescription());
        tvCountLikes.setText(photo.getLikes() + " Likes");

        presenter.hideProgressBar();
    }
}
