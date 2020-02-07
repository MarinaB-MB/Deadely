package com.deadely.retrofitex;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecActivity extends Activity {
    ImageView imageView;
    TextView textView;
    MoviesResponse mMovieResponse;
    public List<Result> mResultList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        imageView = findViewById(R.id.iv_poster);
        textView = findViewById(R.id.tv_title);


        Call<MoviesResponse> call = new APIclient().apIinterface().getMoviesResponses();
        call.enqueue(new Callback<MoviesResponse>() {

            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    MoviesResponse moviesResponse = response.body();
                    mMovieResponse = moviesResponse;
                    mResultList = moviesResponse.getResults();
                    if (mMovieResponse != null) {
                        int position = getIntent().getIntExtra("POS", 0);
                        Result result = mResultList.get(position);
                        textView.setText(result.getTitle());
                        Glide.with(SecActivity.this)
                                .load(result.getPoster().getImage())
                                .into(imageView);
                    }
                } else {
                    Toast.makeText(SecActivity.this, "Error ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your internet connectoin ", Toast.LENGTH_LONG).show();
            }

        });


    }
}
