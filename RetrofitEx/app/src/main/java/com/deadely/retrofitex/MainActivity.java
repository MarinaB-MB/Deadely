package com.deadely.retrofitex;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    GridView gridView;
    Adapter adapter;
    TextView textView;
    EditText editText;
    public ImageView ivSearch, ivClose, ivNSearch;
    private MoviesResponse mMovieResponse;
    private ArrayList<Result> resultList = new ArrayList<>();
    ProgressBar progressBar;
    //SwipeRefreshLayout swipeRefreshLayout;

    public static final String MOVIES = "MainActivity.MOVIES";
    public static final String MOVIES_SEARCH = "MainActivity.MOVIES_SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_search);
        gridView = (GridView) findViewById(R.id.grid_view);
        ivSearch = findViewById(R.id.iv_search);
        ivClose = findViewById(R.id.iv_close);
        ivNSearch = findViewById(R.id.noth_to_search);
        textView = (TextView) findViewById(R.id.tv_nt_search);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        if (savedInstanceState == null) {
            getMovies();
        }
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
                gridView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                ivNSearch.setVisibility(View.GONE);
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
                        adapter = new Adapter(mMovieResponse, MainActivity.this);
                        gridView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your internet connectoin ", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void searchItem(String textToSearch) {
        if (mMovieResponse != null && resultList != null) {
            progressBar.setVisibility(View.VISIBLE);
            resultList.clear();
            for (int i = 0; i < mMovieResponse.getResults().size(); i++) {
                if (mMovieResponse.getResults().get(i).getTitle().toLowerCase().contains(textToSearch.toLowerCase())) {
                    resultList.add(mMovieResponse.getResults().get(i));
                }
            }
            if (resultList.isEmpty()) {
                gridView.setVisibility(View.GONE);
                ivNSearch.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            } else {
                gridView.setVisibility(View.VISIBLE);
                adapter.setData(resultList);
            }
            progressBar.setVisibility(View.INVISIBLE);
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




