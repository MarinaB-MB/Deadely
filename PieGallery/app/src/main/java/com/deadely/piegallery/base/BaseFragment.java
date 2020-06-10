package com.deadely.piegallery.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.deadely.piegallery.App;
import com.deadely.piegallery.di.component.FragmentComponent;
import com.deadely.piegallery.di.module.FragmentModule;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentComponent fragmentComponent = App.getInstance().getComponent().fragmentComponent(new FragmentModule(this));
        inject(fragmentComponent);

    }

    protected abstract void inject(FragmentComponent fragmentComponent);
}
