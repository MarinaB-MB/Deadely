package com.deadely.piegallery.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "sponsorship_table")
public class Sponsorship implements Parcelable {
    @NonNull
    @PrimaryKey
    @SerializedName("impression_urls")
    @Expose
    private List<String> impressionUrls;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("tagline_url")
    @Expose
    private String taglineUrl;
    @Embedded
    @SerializedName("sponsor")
    @Expose
    private Sponsor sponsor;

    public List<String> getImpressionUrls() {
        return impressionUrls;
    }

    public void setImpressionUrls(List<String> impressionUrls) {
        this.impressionUrls = impressionUrls;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTaglineUrl() {
        return taglineUrl;
    }

    public void setTaglineUrl(String taglineUrl) {
        this.taglineUrl = taglineUrl;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.impressionUrls);
        dest.writeString(this.tagline);
        dest.writeString(this.taglineUrl);
        dest.writeParcelable(this.sponsor, flags);
    }

    public Sponsorship() {
    }

    protected Sponsorship(Parcel in) {
        this.impressionUrls = in.createStringArrayList();
        this.tagline = in.readString();
        this.taglineUrl = in.readString();
        this.sponsor = in.readParcelable(Sponsor.class.getClassLoader());
    }

    public static final Creator<Sponsorship> CREATOR = new Creator<Sponsorship>() {
        @Override
        public Sponsorship createFromParcel(Parcel source) {
            return new Sponsorship(source);
        }

        @Override
        public Sponsorship[] newArray(int size) {
            return new Sponsorship[size];
        }
    };
}
