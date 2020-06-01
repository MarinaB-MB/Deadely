package com.deadely.piegallery.view.favorites;

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
import com.deadely.piegallery.dataclasses.Favorites;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private List<Favorites> mFavoritesList;
    public Context context;
    private LayoutInflater layoutInflater;
    public FavoritesAdapter.OnClickListener onClickListener;

    public void setOnClickListener(FavoritesAdapter.OnClickListener onClickListener) {
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
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.rv_item, parent, false);
        return new FavoritesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        Favorites favorite = mFavoritesList.get(position);

        holder.textView.setText("By " + favorite.getPhoto().getUser().getUsername());
        holder.itemView.setBackgroundColor(Color.parseColor(favorite.getPhoto().getColor()));

        Glide.with(context)
                .load(favorite.getPhoto().getUrls().getFull())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                onClickListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFavoritesList == null ? 0 : mFavoritesList.size();
    }

    public void setData(List<Favorites> favoritesList) {
        mFavoritesList = favoritesList;
        notifyDataSetChanged();
    }

    public FavoritesAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public interface OnClickListener {
        void onClickItem(int position);
    }
}
