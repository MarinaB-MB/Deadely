package com.deadely.piegallery.view.photos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.deadely.piegallery.R;
import com.deadely.piegallery.dataclasses.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<Photo> mPhotoList;
    public Context context;
    private LayoutInflater layoutInflater;
    public OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView imageView;
        @BindView(R.id.tv_desc_photo)
        TextView textView;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);


        holder.textView.setText("By " + photo.getUser().getUsername());
        holder.itemView.setBackgroundColor(Color.parseColor(photo.getColor()));

        Glide.with(context)
                .load(photo.getUrls().getFull())
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPhotoList == null ? 0 : mPhotoList.size();
    }

    public void setData(List<Photo> photoList) {
        mPhotoList = photoList;
        notifyDataSetChanged();
    }

    public PhotoAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public interface OnClickListener {
        void onClickItem(int position);
    }
}