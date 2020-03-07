package com.deadely.m_v_p.presenter.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;

import com.deadely.m_v_p.network.ApiClient;
import com.deadely.m_v_p.R;
import com.deadely.m_v_p.model.moviesresponseclass.MoviesResponse;
import com.deadely.m_v_p.view.film.FilmActivity;
import com.deadely.m_v_p.view.main.MainActivity;
import com.deadely.m_v_p.view.main.MainAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements IPresenter {

    public MoviesResponse movieResponse, mMovieResponse;
    MainActivity mainActivity;

    public Presenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void getMovies() {
        showProgress();

        Call<MoviesResponse> call = new ApiClient().apIinterface().getMoviesResponses();
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    mMovieResponse = moviesResponse;
                    if (mMovieResponse != null) {
                        if (mMovieResponse.getResults().isEmpty()) {

                            emptySearch();

                            Toast.makeText(mainActivity.getApplicationContext(), "Error 1", Toast.LENGTH_LONG).show();
                        } else {
                            hideProgress();

                            mainActivity.recyclerView.setLayoutManager(new GridLayoutManager(mainActivity, 2));
                            mainActivity.adapter = new MainAdapter(mMovieResponse, mainActivity);
                            mainActivity.adapter.setOnClickListener(mainActivity);
                            mainActivity.recyclerView.setAdapter(mainActivity.adapter);

                        }
                    }
                } else {
                    emptySearch();
                    Toast.makeText(mainActivity.getApplicationContext(), "Error 2", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                mainActivity.searchLayout.setVisibility(View.GONE);
                mainActivity.recyclerView.setVisibility(View.GONE);
                mainActivity.progressLayout.setVisibility(View.GONE);
                Toast.makeText(mainActivity.getApplicationContext(), "Check your internet connection ", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void initList() {
        if (this.movieResponse != null) {
            mainActivity.resultList.clear();
            mainActivity.adapter.setData(this.movieResponse.getResults());
        } else {
            getMovies();
        }
    }

    @Override
    public void onSetListeners() {

        mainActivity.findViewById(R.id.iv_close).setOnClickListener(v -> btnClean());
        mainActivity.mSwipeRefreshLayout.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            mainActivity.mSwipeRefreshLayout.setRefreshing(false);
            initList();
        }, 4000));
        mainActivity.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideProgress();

                if (s.toString().equals("")) {
                    initList();
                } else {
                    onSearchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onSearchItem(String textToSearch) {
        if (mMovieResponse != null && mainActivity.resultList != null) {
            mainActivity.resultList.clear();
            for (int i = 0; i < mMovieResponse.getResults().size(); i++) {
                if (mMovieResponse.getResults().get(i).getTitle().toLowerCase().contains(textToSearch.toLowerCase())) {
                    mainActivity.resultList.add(mMovieResponse.getResults().get(i));
                }
            }
            if (mainActivity.resultList.isEmpty()) {
                emptySearch();
            } else {
                hideProgress();
                mainActivity.adapter.setData(mainActivity.resultList);
            }
        } else {
            getMovies();
        }
    }


    @Override
    public void btnClean() {
        mainActivity.editText.getText().clear();
    }

    @Override
    public void onClickItemResult(int position) {
        Intent intent = new Intent(mainActivity, FilmActivity.class);
        Bundle bundle = new Bundle();
        if (mainActivity.resultList.isEmpty()) {
            bundle.putParcelable(FilmActivity.MOVIE, mMovieResponse.getResults().get(position));
        } else {
            bundle.putParcelable(FilmActivity.MOVIE, mainActivity.resultList.get(position));
        }
        intent.putExtra(FilmActivity.BUNDLE, bundle);
        mainActivity.startActivity(intent);
    }


    @Override
    public void showProgress() {
        mainActivity.searchLayout.setVisibility(View.GONE);
        mainActivity.recyclerView.setVisibility(View.GONE);
        mainActivity.progressLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mainActivity.searchLayout.setVisibility(View.GONE);
        mainActivity.recyclerView.setVisibility(View.VISIBLE);
        mainActivity.progressLayout.setVisibility(View.GONE);
    }

    @Override
    public void emptySearch() {
        mainActivity.searchLayout.setVisibility(View.VISIBLE);
        mainActivity.recyclerView.setVisibility(View.GONE);
        mainActivity.progressLayout.setVisibility(View.GONE);
    }

}
