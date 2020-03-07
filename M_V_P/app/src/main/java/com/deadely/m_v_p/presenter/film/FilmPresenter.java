package com.deadely.m_v_p.presenter.film;

import com.bumptech.glide.Glide;
import com.deadely.m_v_p.model.resultclass.Result;
import com.deadely.m_v_p.view.film.FilmActivity;

import static com.deadely.m_v_p.view.film.FilmActivity.MOVIE;

public class FilmPresenter implements IFilmPresenter {

    FilmActivity filmActivity;
    Result movie;

    public FilmPresenter(FilmActivity filmActivity) {
        this.filmActivity = filmActivity;
    }

    @Override
    public void getData() {
        if (filmActivity.bundle != null) {
            movie = filmActivity.bundle.getParcelable(MOVIE);
        }
        if (movie != null) {
            filmActivity.textView.setText(movie.getTitle());
            Glide.with(filmActivity)
                    .load(movie.getPoster().getImage())
                    .into(filmActivity.imageView);
        }
    }
}
