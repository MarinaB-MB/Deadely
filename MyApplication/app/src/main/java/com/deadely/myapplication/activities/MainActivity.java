package com.deadely.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.deadely.myapplication.R;
import com.deadely.myapplication.adapters.MainAdapter;
import com.deadely.myapplication.dataclass.MoviesResponse;
import com.deadely.myapplication.dataclass.Result;
import com.deadely.myapplication.network.APIclient;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    public static final String MOVIES = "MainActivity.MOVIES";
    public static final String MOVIES_SEARCH = "MainActivity.MOVIES_SEARCH";

    @BindView(R.id.et_search)
    EditText editText;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.r_view)
    RecyclerView recyclerView;
    @BindView(R.id.nSearch_layout)
    ConstraintLayout searchLayout;
    @BindView(R.id.rw_layout)
    LinearLayout rwLayout;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.progress_layout)
    ConstraintLayout progressLayout;

    private MoviesResponse mMovieResponse;
    private ArrayList<Result> resultList = new ArrayList<>();
    public MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getMovies();
        }
//        setListeners();

        mSwipeRefreshLayout.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            mSwipeRefreshLayout.setRefreshing(false);
            initList();
        }, 4000));
        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(MOVIES, mMovieResponse);
        outState.putParcelableArrayList(MOVIES_SEARCH, resultList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mMovieResponse = savedInstanceState.getParcelable(MOVIES);
        resultList = savedInstanceState.getParcelableArrayList(MOVIES_SEARCH);
    }

    private void setListeners() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rwLayout.setVisibility(View.VISIBLE);
                searchLayout.setVisibility(View.GONE);
                if (s.toString().equals("")) {
                    initList();
                } else {
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void getMovies() {
        rwLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.GONE);
        progressLayout.setVisibility(View.VISIBLE);

        Call<MoviesResponse> call = new APIclient().apIinterface().getMoviesResponses();
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    mMovieResponse = moviesResponse;
                    if (mMovieResponse != null) {
                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                        adapter = new MainAdapter(mMovieResponse, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                        if (mMovieResponse.getResults().isEmpty()) {
                            searchLayout.setVisibility(View.VISIBLE);
                            rwLayout.setVisibility(View.GONE);
                            progressLayout.setVisibility(View.GONE);
                        } else {
                            searchLayout.setVisibility(View.GONE);
                            rwLayout.setVisibility(View.VISIBLE);
                            progressLayout.setVisibility(View.GONE);
                        }
                    }
                } else {
                    searchLayout.setVisibility(View.VISIBLE);
                    rwLayout.setVisibility(View.GONE);
                    progressLayout.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your internet connectoin ", Toast.LENGTH_LONG).show();
                searchLayout.setVisibility(View.GONE);
            }
        });

    }

    public void searchItem(String textToSearch) {
        if (mMovieResponse != null && resultList != null) {
            resultList.clear();
            for (int i = 0; i < mMovieResponse.getResults().size(); i++) {
                if (mMovieResponse.getResults().get(i).getTitle().toLowerCase().contains(textToSearch.toLowerCase())) {
                    resultList.add(mMovieResponse.getResults().get(i));
                }
            }
            if (resultList.isEmpty()) {
                rwLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            } else {
                rwLayout.setVisibility(View.VISIBLE);
                adapter.setData(resultList);
            }
        } else {
            getMovies();
        }
    }


    public void initList() {
        if (mMovieResponse != null) {
            resultList.clear();
            adapter.setData(mMovieResponse.getResults());
        } else {
            getMovies();
        }
    }

    public void btnClean(View view) {
        editText.getText().clear();
    }


}




