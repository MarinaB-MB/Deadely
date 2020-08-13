package com.deadely.itl_en.ui.vocab.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.dataclasses.Words
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.vocab.IVocabContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class VocabPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<IVocabContract.View>(), IVocabContract.Presenter {

    lateinit var list: MutableList<Words>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWords()
    }

    override fun getWords() {
        getMvpView()?.startLoading()
        db.groupDao().deleteAllGroup()

        val call = apiInterface.getWords()
        call.enqueue(object : retrofit2.Callback<MutableList<Words>> {
            override fun onResponse(call: Call<MutableList<Words>>, response: Response<MutableList<Words>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    db.wordDao().addList(list)
                    getMvpView()?.initData(list)
                    getMvpView()?.completeLoading()
                } else {
                    getMvpView()?.errorLoading()
                }
            }

            override fun onFailure(call: Call<MutableList<Words>>, t: Throwable) {
                getMvpView()?.errorLoading()
            }
        })
    }
}
