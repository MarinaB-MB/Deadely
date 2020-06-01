package com.deadely.piegallery.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "profile_image_table")
public class Profile_Image implements Parcelable {
    @NonNull
    @ColumnInfo(name = "profile_image_small")
    @SerializedName("small")
    @PrimaryKey
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.medium);
        dest.writeString(this.large);
    }

    public Profile_Image() {
    }

    protected Profile_Image(Parcel in) {
        this.small = in.readString();
        this.medium = in.readString();
        this.large = in.readString();
    }

    public static final Creator<Profile_Image> CREATOR = new Creator<Profile_Image>() {
        @Override
        public Profile_Image createFromParcel(Parcel source) {
            return new Profile_Image(source);
        }

        @Override
        public Profile_Image[] newArray(int size) {
            return new Profile_Image[size];
        }
    };
}
