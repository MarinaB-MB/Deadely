package com.deadely.piegallery.view.info.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import com.deadely.piegallery.R;
import com.deadely.piegallery.base.BaseFragment;
import com.deadely.piegallery.di.component.FragmentComponent;
import com.deadely.piegallery.view.info.IInfoContract;
import com.deadely.piegallery.view.map.MapsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoFragment extends BaseFragment implements android.view.View.OnClickListener, IInfoContract.View {
    @BindView(R.id.btn_map)
    Button btnMap;
    private Unbinder unbinder;
    @Inject
    public IInfoContract.Presenter infoPresenter;


    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_info, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        return view;
    }

    private void initView() {
        infoPresenter.attachView(this);
        btnMap.setOnClickListener(this);
    }


    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.btn_map:
                startActivity(new Intent(getContext(), MapsActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        infoPresenter.detachView();
    }

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
