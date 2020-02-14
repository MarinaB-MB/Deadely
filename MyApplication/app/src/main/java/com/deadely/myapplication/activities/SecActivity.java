package com.deadely.myapplication.activities;

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
import com.deadely.myapplication.network.APIclient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecActivity extends FragmentActivity {
    @BindView(R.id.iv_poster)
    ImageView imageView;

    @BindView(R.id.tv_title)
    TextView textView;

    MoviesResponse mMovieResponse;
    public List<Result> mResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);

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
                Toast.makeText(SecActivity.this, "Error ", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
