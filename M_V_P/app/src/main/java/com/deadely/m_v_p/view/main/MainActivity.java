package com.deadely.m_v_p.view.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.deadely.m_v_p.R;
import com.deadely.m_v_p.model.resultclass.Result;
import com.deadely.m_v_p.presenter.main.Presenter;
import com.deadely.m_v_p.view.film.FilmActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements IView, MainAdapter.OnClickListener {

    Presenter presenter;
    public MainAdapter adapter;

    @BindView(R.id.et_search)
    public EditText editText;
    @BindView(R.id.rv_movies)
    public RecyclerView recyclerView;
    @BindView(R.id.noth_search_layout)
    public ConstraintLayout searchLayout;
    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.progress_layout)
    public ConstraintLayout progressLayout;

    public ArrayList<Result> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
        onMovieResult();
        setListeners();

    }

    @Override
    public void onMovieResult() {
        presenter.getMovies();
    }

    @Override
    public void setListeners() {
        presenter.onSetListeners();
    }


    @Override
    public void onClickItem(int position) {
      presenter.onClickItemResult(position);
    }
}