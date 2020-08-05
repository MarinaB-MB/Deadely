package com.deadely.itl_en.ui.vocab.presenter

import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.dataclasses.Words
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.vocab.IVocabContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class VocabPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<IVocabContract.View>(), IVocabContract.Presenter {

    lateinit var list: MutableList<Words>
    override fun getWords() {
        db.groupDao().deleteAllGroup()

        val call = apiInterface.getWords()
        call.enqueue(object : retrofit2.Callback<MutableList<Words>> {
            override fun onResponse(call: Call<MutableList<Words>>, response: Response<MutableList<Words>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    for (word in list) {
                        db.wordDao().addWord(word)
                    }
                    getMvpView()?.initData(list)
                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
                }
            }

            override fun onFailure(call: Call<MutableList<Words>>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString())
            }
        })
    }
}
