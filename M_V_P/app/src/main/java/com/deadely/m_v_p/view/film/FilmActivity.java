package com.deadely.m_v_p.view.film;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.deadely.m_v_p.R;
import com.deadely.m_v_p.presenter.film.FilmPresenter;
import com.deadely.m_v_p.presenter.film.IFilmPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmActivity extends AppCompatActivity implements IFilmActivity {

    public Bundle bundle;
    IFilmPresenter presenter;

    public static final String BUNDLE = "FilmActivity.BUNDLE";
    public static final String MOVIE = "FilmActivity.MOVIE";

    @BindView(R.id.iv_poster)
    public ImageView imageView;
    @BindView(R.id.tv_title)
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        ButterKnife.bind(this);

        presenter = new FilmPresenter(this);
        getDataResult();
    }

    @Override
    public void getDataResult() {
        if (getIntent().getExtras() != null) {
            bundle = getIntent().getExtras().getBundle(BUNDLE);
            presenter.getData();
        }
    }
}
