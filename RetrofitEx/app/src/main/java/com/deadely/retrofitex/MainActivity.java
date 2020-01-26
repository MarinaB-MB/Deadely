package com.deadely.retrofitex;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    GridView gridView;
    Adapter adapter;
    EditText editText;
<<<<<<< HEAD
    public ImageView ivSearch, ivClose, ivNSearch;
=======
    public ImageView ivSearch, ivClose;
>>>>>>> 6041d362524645fa7be76ec5e75b6ec6c4d42f47
    private MoviesResponse mMovieResponse;
    private List<Result> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_search);
        gridView = (GridView) findViewById(R.id.grid_view);
        ivSearch = findViewById(R.id.iv_search);
        ivClose = findViewById(R.id.iv_close);
        ivNSearch = findViewById(R.id.noth_to_search);

<<<<<<< HEAD
        getMovies();
        setListeners();

=======
        setListeners();
        getMovies();
>>>>>>> 6041d362524645fa7be76ec5e75b6ec6c4d42f47
    }

    private void setListeners() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gridView.setVisibility(View.VISIBLE);
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
                Toast.makeText(getApplicationContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void searchItem(String textToSearch) {
        resultList.clear();
        for (int i = 0; i < mMovieResponse.getResults().size(); i++) {
            if (mMovieResponse.getResults().get(i).getTitle().toLowerCase().contains(textToSearch.toLowerCase())) {
                resultList.add(mMovieResponse.getResults().get(i));
<<<<<<< HEAD


            }
        }
        if (resultList.isEmpty()) {
            gridView.setVisibility(View.GONE);
            ivNSearch.setVisibility(View.VISIBLE);


        } else {
            gridView.setVisibility(View.VISIBLE);
            adapter.setData(resultList);
        }
=======
            }
        }
        if (resultList.isEmpty()) {
                gridView.setVisibility(View.GONE);

        } else {
            adapter.setData(resultList);
        }
    }

    public void initList() {
        resultList.clear();
        adapter.setData(mMovieResponse.getResults());
>>>>>>> 6041d362524645fa7be76ec5e75b6ec6c4d42f47
    }

    public void initList() {
        resultList.clear();
        adapter.setData(mMovieResponse.getResults());
    }

    public void btnClean(View view) {
        editText.getText().clear();
    }

}




