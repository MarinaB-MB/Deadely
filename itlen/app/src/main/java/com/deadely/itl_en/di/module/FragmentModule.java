package com.deadely.itl_en.di.module;

import androidx.fragment.app.Fragment;

import dagger.Module;

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
