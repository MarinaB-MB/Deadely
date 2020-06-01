package com.deadely.piegallery.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "links_2_table")
public class Links_2 implements Parcelable {
    @NonNull
    @ColumnInfo(name = "links_2_self")
    @SerializedName("self")
    @Expose
    @PrimaryKey
    private String self;

    @SerializedName("html")
    @ColumnInfo(name = "links_2_html")
    @Expose
    private String html;
    @SerializedName("photos")
    @Expose
    private String photos;

    @ColumnInfo(name = "links_2_likes")
    @SerializedName("likes")
    @Expose
    private String likes;

    @SerializedName("portfolio")
    @Expose
    private String portfolio;

    @SerializedName("following")
    @Expose
    private String following;

    @SerializedName("followers")
    @Expose
    private String followers;


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.html);
        dest.writeString(this.photos);
        dest.writeString(this.likes);
        dest.writeString(this.portfolio);
        dest.writeString(this.following);
        dest.writeString(this.followers);
    }

    public Links_2() {
    }

    protected Links_2(Parcel in) {
        this.self = in.readString();
        this.html = in.readString();
        this.photos = in.readString();
        this.likes = in.readString();
        this.portfolio = in.readString();
        this.following = in.readString();
        this.followers = in.readString();
    }

    public static final Creator<Links_2> CREATOR = new Creator<Links_2>() {
        @Override
        public Links_2 createFromParcel(Parcel source) {
            return new Links_2(source);
        }

        @Override
        public Links_2[] newArray(int size) {
            return new Links_2[size];
        }
    };
}
