package com.deadely.itl_en.ui.study.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseFragment
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.ui.study.IStudyContract
import javax.inject.Inject

class StudyFragment : BaseFragment(), IStudyContract.View {
    @Inject
    private lateinit var presenter: IStudyContract.Presenter
    override fun inject(fragmentComponent: FragmentComponent?) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_study, container, false)
    }

    override fun showMessage(msg: String) {
        TODO("Not yet implemented")
    }
}