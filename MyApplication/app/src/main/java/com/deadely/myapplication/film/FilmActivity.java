package com.deadely.myapplication.film;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.deadely.myapplication.R;
import com.deadely.myapplication.dataclass.MoviesResponse;
import com.deadely.myapplication.dataclass.Result;
import com.deadely.myapplication.maps.MapsActivity;
import com.deadely.myapplication.network.APIclient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmActivity extends FragmentActivity {

    @BindView(R.id.iv_poster)
    ImageView imageView;
    @BindView(R.id.tv_title)
    TextView textView;

    MoviesResponse mMovieResponse;
    public List<Result> mResultList;
    ArrayList<Result> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        ButterKnife.bind(this);

        getMovies();

    }

    private void getMovies() {
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
                        Glide.with(FilmActivity.this)
                                .load(result.getPoster().getImage())
                                .into(imageView);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Check your internet connection ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your internet connection ", Toast.LENGTH_LONG).show();
            }
        });

    }

    @OnClick(R.id.btn_map)
    void onClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
