package com.deadely.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

import com.deadely.myapplication.network.APIclient;
import com.deadely.myapplication.Adapters.Adapter;
import com.deadely.myapplication.dataclass.MoviesResponse;
import com.deadely.myapplication.dataclass.Result;
import com.deadely.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    Adapter adapter;
    TextView textView;
    EditText editText;
    public ImageView ivSearch, ivClose, ivNSearch;
    private MoviesResponse mMovieResponse;
    private ArrayList<Result> resultList = new ArrayList<>();
    ProgressBar progressBar;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ConstraintLayout searchLayout;
    RecyclerView recyclerView;

    public static final String MOVIES = "MainActivity.MOVIES";
    public static final String MOVIES_SEARCH = "MainActivity.MOVIES_SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_search);
        recyclerView = (RecyclerView) findViewById(R.id.r_view);
        ivSearch = findViewById(R.id.iv_search);
        ivClose = findViewById(R.id.iv_close);
        ivNSearch = findViewById(R.id.noth_to_search);
        textView = (TextView) findViewById(R.id.tv_nt_search);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh);
        searchLayout = findViewById(R.id.nSearch_layout);

        if (savedInstanceState == null) {
            getMovies();
        }

        mSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                initList();
            }
        });
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
                mSwipeRefreshLayout.setVisibility(View.VISIBLE);
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

        Call<MoviesResponse> call = new APIclient().apIinterface().getMoviesResponses();
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    mMovieResponse = moviesResponse;
                    if (mMovieResponse != null) {
                        mSwipeRefreshLayout.setVisibility(View.GONE);
                        searchLayout.setVisibility(View.GONE);
                        progressBar.setVisibility(View.VISIBLE);

                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                        adapter = new Adapter(mMovieResponse, MainActivity.this);
                        recyclerView.setAdapter(adapter);

                        progressBar.setVisibility(View.GONE);
                        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                    }
                } else {
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
        if (mSwipeRefreshLayout.isShown()) {
            if (mMovieResponse != null && resultList != null) {

                resultList.clear();
                for (int i = 0; i < mMovieResponse.getResults().size(); i++) {
                    if (mMovieResponse.getResults().get(i).getTitle().toLowerCase().contains(textToSearch.toLowerCase())) {
                        resultList.add(mMovieResponse.getResults().get(i));
                    }
                }
                if (resultList.isEmpty()) {
                    mSwipeRefreshLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                } else {
                    mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                    adapter.setData(resultList);
                }
            } else {
                getMovies();
            }
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




