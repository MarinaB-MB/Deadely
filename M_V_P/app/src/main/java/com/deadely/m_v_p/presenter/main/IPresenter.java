package com.deadely.m_v_p.presenter.main;

public interface IPresenter {
    void getMovies();

    void initList();

    void onSetListeners();

    void onSearchItem(String textToSearch);

    void btnClean();

    void onClickItemResult(int position);

    void showProgress();

    void hideProgress();

    void emptySearch();

}
