package com.deadely.piegallery.view.info.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.deadely.piegallery.R;
import com.deadely.piegallery.view.info.IInfoContract;
import com.deadely.piegallery.view.info.presenter.InfoPresenter;
import com.deadely.piegallery.view.map.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoFragment extends Fragment implements View.OnClickListener, IInfoContract.IView {
    @BindView(R.id.btn_map)
    Button btnMap;
    private Unbinder unbinder;
    private InfoPresenter infoPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        return view;
    }

    private void initView() {
        infoPresenter = new InfoPresenter(this);
        btnMap.setOnClickListener(this);
    }


    public void onClick(View v) {
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
    }
}
