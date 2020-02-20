package com.deadely.myapplication.main;

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
import com.deadely.myapplication.R;
import com.deadely.myapplication.dataclass.MoviesResponse;
import com.deadely.myapplication.dataclass.Result;
import com.deadely.myapplication.film.FilmActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    public static final String POS = "MainAdapter.POSITION";

    public List<Result> mResultList;
    public Context context;
    private LayoutInflater layoutInflater;

    public void setData(List<Result> resultList) {
        mResultList = resultList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;


        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_image);
            textView = view.findViewById(R.id.tv_text);
        }
    }

    public MainAdapter(MoviesResponse movieResponse, Context context) {
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

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, FilmActivity.class);
            intent.putExtra(POS, position);
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }
}
