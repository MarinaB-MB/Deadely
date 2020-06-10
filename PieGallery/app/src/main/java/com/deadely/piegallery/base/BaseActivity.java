package com.deadely.piegallery.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.deadely.piegallery.App;
import com.deadely.piegallery.di.component.ActivityComponent;
import com.deadely.piegallery.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponent activityComponent = App.getInstance().getComponent().activityComponent(new ActivityModule(this));
        inject(activityComponent);
    }

    protected abstract void inject(ActivityComponent activityComponent);
}
