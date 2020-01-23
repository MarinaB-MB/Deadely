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
    public List<Result> resultList;
    public Context context;

    public Adapter(MoviesResponse movieResponse, Context context) {

        this.context = context;
        this.resultList = movieResponse.getResults();
    }

    @Override
    public int getCount() {
        return resultList.size();
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
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        TextView textView = view.findViewById(R.id.text);
        ImageView imageView = view.findViewById(R.id.image);


        textView.setText(resultList.get(position).getTitle());
        Glide.with(context)
                .load(resultList.get(position).getPoster().getImage())
                .into(imageView);
        return view;
    }


}
