package com.deadely.retrofitex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {
    public List<Result> mResultList;

    public Context context;
    private LayoutInflater layoutInflater;


    public void setData(List<Result> resultList) {
        mResultList = resultList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            textView = (TextView) view.findViewById(R.id.text);
        }
    }

    public RAdapter(MoviesResponse movieResponse, Context context) {
        this.context = context;
        this.mResultList = movieResponse.getResults();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Result result = mResultList.get(position);

        holder.textView.setText(result.getTitle());
        Glide.with(context)
                .load(result.getPoster().getImage())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SecActivity.class);
                intent.putExtra("POS", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }


}
