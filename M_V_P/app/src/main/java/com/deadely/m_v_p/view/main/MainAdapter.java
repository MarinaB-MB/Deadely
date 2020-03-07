package com.deadely.m_v_p.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deadely.m_v_p.R;
import com.deadely.m_v_p.model.moviesresponseclass.MoviesResponse;
import com.deadely.m_v_p.model.resultclass.Result;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    public List<Result> mResultList;
    public Context context;
    private LayoutInflater layoutInflater;

    public OnClickListener onClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tv_text);
            imageView = view.findViewById(R.id.iv_image);
        }

    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setData(List<Result> resultList) {
        mResultList = resultList;
        notifyDataSetChanged();
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
            if (onClickListener != null) {
                onClickListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    public interface OnClickListener {
        void onClickItem(int position);
    }
}