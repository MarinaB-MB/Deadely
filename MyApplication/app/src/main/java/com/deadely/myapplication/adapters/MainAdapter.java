package com.deadely.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deadely.myapplication.R;
import com.deadely.myapplication.dataclass.Result;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    public List<Result> mResultList;
    public Context context;
    private LayoutInflater layoutInflater;

    public OnClickListener onClickListener;


    public void setData(List<Result> resultList) {
        mResultList = resultList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            ;
            textView = view.findViewById(R.id.text);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public MainAdapter(Context context) {
        this.context = context;
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
                if (onClickListener != null) {
                    onClickListener.onClickItem(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mResultList == null ? 0 : mResultList.size();
    }

    public interface OnClickListener {
        void onClickItem(int position);
    }
}
