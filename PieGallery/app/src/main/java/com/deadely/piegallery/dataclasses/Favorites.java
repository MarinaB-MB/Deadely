package com.deadely.piegallery.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites_table")
public class Favorites implements Parcelable {

    public Favorites(Photo photo) {
        this.photo = photo;
    }

    public Favorites() {
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fav_id")
    private int id;

    @Embedded
    private Photo photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public static Creator<Favorites> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.photo, flags);
    }

    protected Favorites(Parcel in) {
        this.id = in.readInt();
        this.photo = in.readParcelable(Photo.class.getClassLoader());
    }

    public static final Creator<Favorites> CREATOR = new Creator<Favorites>() {
        @Override
        public Favorites createFromParcel(Parcel source) {
            return new Favorites(source);
        }

        @Override
        public Favorites[] newArray(int size) {
            return new Favorites[size];
        }
    };
}
