package com.deadely.m_v_p.model.posterclass;

import android.os.Parcel;
import android.os.Parcelable;

import com.deadely.m_v_p.model.sourceclass.Source;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Poster implements Parcelable, IP {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("source")
    @Expose
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeParcelable((Parcelable) this.source, flags);
    }

    public Poster() {
    }

    protected Poster(Parcel in) {
        this.image = in.readString();
        this.source = in.readParcelable(Source.class.getClassLoader());
    }

    public static final Parcelable.Creator<Poster> CREATOR = new Parcelable.Creator<Poster>() {
        @Override
        public Poster createFromParcel(Parcel source) {
            return new Poster(source);
        }

        @Override
        public Poster[] newArray(int size) {
            return new Poster[size];
        }
    };

    @Override
    public String getImage() {
        return image;
    }
}
