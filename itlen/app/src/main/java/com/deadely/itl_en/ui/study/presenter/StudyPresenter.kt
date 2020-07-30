package com.deadely.itl_en.ui.study.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.ui.study.IStudyContract
import javax.inject.Inject

class StudyPresenter : BasePresenter<IStudyContract.View>, IStudyContract.Presenter {
    @Inject
    constructor()
}

