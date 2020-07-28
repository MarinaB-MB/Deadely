package com.deadely.itl_en.di.component;

import com.deadely.itl_en.di.PerFragment;
import com.deadely.itl_en.di.module.DatabaseModule;
import com.deadely.itl_en.di.module.FragmentModule;
import com.deadely.itl_en.di.module.NetModule;
import com.deadely.itl_en.di.module.PresenterModule;
import com.deadely.itl_en.main.stat.view.StatFragment;
import com.deadely.itl_en.main.study.view.StudyFragment;
import com.deadely.itl_en.main.vocab.view.VocabFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {FragmentModule.class, PresenterModule.class, DatabaseModule.class, NetModule.class})
public interface FragmentComponent {
    void inject(StatFragment fragment);

    void inject(StudyFragment fragment);

    void inject(VocabFragment fragment);

}
