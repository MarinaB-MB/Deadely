package com.deadely.myapplication.film;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.deadely.myapplication.R;
import com.deadely.myapplication.dataclass.Result;
import com.deadely.myapplication.maps.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilmActivity extends FragmentActivity {

    public static final String BUNDLE = "FilmActivity.BUNDLE";
    public static final String MOVIE = "FilmActivity.MOVIE";

    @BindView(R.id.iv_poster)
    ImageView imageView;
    @BindView(R.id.tv_title)
    TextView textView;

    Result movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras().getBundle(BUNDLE);
            if (bundle != null) {
                movie = bundle.getParcelable(MOVIE);
            }
        }
        if (movie != null) {
            textView.setText(movie.getTitle());
            Glide.with(FilmActivity.this)
                    .load(movie.getPoster().getImage())
                    .into(imageView);
        }
    }

    @OnClick(R.id.btn_map)
    void onClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
