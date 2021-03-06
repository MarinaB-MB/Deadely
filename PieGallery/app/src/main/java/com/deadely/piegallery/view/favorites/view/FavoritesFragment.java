package com.deadely.piegallery.view.favorites.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.deadely.piegallery.R;
import com.deadely.piegallery.base.BaseFragment;
import com.deadely.piegallery.dataclasses.Favorites;
import com.deadely.piegallery.di.component.FragmentComponent;
import com.deadely.piegallery.view.detailphoto.view.DetailPhotoActivity;
import com.deadely.piegallery.view.favorites.FavoritesAdapter;
import com.deadely.piegallery.view.favorites.IFavoritesContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.deadely.piegallery.view.photos.view.PhotosFragment.ID;

public class FavoritesFragment extends BaseFragment implements IFavoritesContract.View, FavoritesAdapter.OnClickListener {
    @BindView(R.id.rv_fav_list)
    RecyclerView rvFavList;
    @BindView(R.id.pb_fav)
    ProgressBar pbFav;
    @BindView(R.id.swiperl_fav)
    SwipeRefreshLayout swiperlFav;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    private Unbinder unbinder;


    private List<Favorites> favoritesList;
    @Inject
    public IFavoritesContract.Presenter presenter;
    private FavoritesAdapter favoritesAdapter;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
        presenter.attachView(this);

        rvFavList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        favoritesAdapter = new FavoritesAdapter(getContext());
        rvFavList.setAdapter(favoritesAdapter);
        favoritesAdapter.setOnClickListener(this);

        swiperlFav.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            swiperlFav.setRefreshing(false);
            getData();
        }, 1000));

        setHasOptionsMenu(true);

        getData();
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.favorites_list_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_clear_list:
                presenter.clearList();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getData() {
        presenter.showProgressBar();
        presenter.getPhotoList();
    }

    @Override
    public void showProgress() {
        rvFavList.setVisibility(GONE);
        pbFav.setVisibility(VISIBLE);
        tvEmpty.setVisibility(GONE);
    }

    @Override
    public void setEmptyList() {
        rvFavList.setVisibility(GONE);
        pbFav.setVisibility(GONE);
        tvEmpty.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbFav.setVisibility(GONE);
        rvFavList.setVisibility(VISIBLE);
        tvEmpty.setVisibility(GONE);
    }

    @Override
    public void setPhotoList(List<Favorites> list) {
        favoritesList = list;
        favoritesAdapter.setData(favoritesList);
        presenter.hideProgressBar();
    }

    @Override
    public void onClickItem(int position) {
        Intent intent = new Intent(getContext(), DetailPhotoActivity.class);
        intent.putExtra(ID, favoritesList.get(position).getPhoto().getId());
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachView();
    }
}
