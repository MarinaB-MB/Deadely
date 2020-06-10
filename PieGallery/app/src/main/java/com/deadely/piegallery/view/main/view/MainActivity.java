package com.deadely.piegallery.view.main.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.deadely.piegallery.R;
import com.deadely.piegallery.base.BaseActivity;
import com.deadely.piegallery.di.component.ActivityComponent;
import com.deadely.piegallery.view.favorites.view.FavoritesFragment;
import com.deadely.piegallery.view.info.view.InfoFragment;
import com.deadely.piegallery.view.main.IMainContract;
import com.deadely.piegallery.view.photos.view.PhotosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainContract.View {

    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;
    @Inject
    public IMainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadFragment(new PhotosFragment());
        initView();
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void initView() {
        presenter.attachView(this);
        bottomNav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_favorites:
                    loadFragment(new FavoritesFragment());
                    break;
                case R.id.nav_photos:
                    loadFragment(new PhotosFragment());
                    break;
                case R.id.nav_info:
                    loadFragment(new InfoFragment());
                    break;
            }
            return true;
        });
    }
}
