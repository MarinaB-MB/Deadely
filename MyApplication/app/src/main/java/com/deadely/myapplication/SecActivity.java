package com.deadely.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecActivity extends FragmentActivity {
    ImageView imageView;
    TextView textView;
    MoviesResponse mMovieResponse;
    public List<Result> mResultList;
    private GoogleMap mMap;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        imageView = findViewById(R.id.iv_poster);
        textView = findViewById(R.id.tv_title);
        btn = findViewById(R.id.btn_map);

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


                    } else {

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
