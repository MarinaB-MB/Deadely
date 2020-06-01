package com.deadely.piegallery.view.main.view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.deadely.piegallery.R;
import com.deadely.piegallery.view.favorites.view.FavoritesFragment;
import com.deadely.piegallery.view.info.view.InfoFragment;
import com.deadely.piegallery.view.main.IMainContract;
import com.deadely.piegallery.view.main.presenter.MainPresenter;
import com.deadely.piegallery.view.photos.view.PhotosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainContract.IView {

    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadFragment(new PhotosFragment());
        initView();
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
        presenter = new MainPresenter(this);

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
