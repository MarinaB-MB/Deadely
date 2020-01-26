package com.deadely.retrofitex;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends BaseAdapter {
    public List<Result> mResultList;
    public Context context;
    private LayoutInflater layoutInflater;

    public Adapter(MoviesResponse movieResponse, Context context) {
        this.context = context;
        this.mResultList = movieResponse.getResults();
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<Result> resultList) {
        mResultList = resultList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mResultList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.item, parent, false);
        TextView textView = convertView.findViewById(R.id.text);
        ImageView imageView = convertView.findViewById(R.id.image);
        Result result = mResultList.get(position);

        textView.setText(result.getTitle());
        Glide.with(context)
                .load(result.getPoster().getImage())
                .into(imageView);

        return convertView;
    }


}
