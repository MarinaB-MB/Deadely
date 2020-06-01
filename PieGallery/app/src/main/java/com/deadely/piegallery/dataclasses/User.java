package com.deadely.piegallery.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user_table")
public class User implements Parcelable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id")
    @SerializedName("id")
    @Expose
    private String id;

    @ColumnInfo(name = "user_updated_at")
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("username")
    @ColumnInfo(name = "user_username")
    @Expose
    private String username;

    @ColumnInfo(name = "user_name")
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo(name = "user_first_name")
    @SerializedName("first_name")
    @Expose
    private String firstName;

    @ColumnInfo(name = "user_last_name")
    @SerializedName("last_name")
    @Expose
    private String lastName;

    @ColumnInfo(name = "user_twitter_username")
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;

    @ColumnInfo(name = "user_portfolio_url")
    @SerializedName("portfolio_url")
    @Expose
    private String portfolioUrl;

    @SerializedName("bio")
    @Expose
    @ColumnInfo(name = "user_bio")
    private String bio;

    @SerializedName("location")
    @ColumnInfo(name = "user_location")
    @Expose
    private String location;

    @Embedded(prefix = "_")
    @SerializedName("links")
    @Expose
    private Links_2 links;

    @Embedded(prefix = "_")
    @SerializedName("profile_image")
    @Expose
    private Profile_Image profileImage;

    @SerializedName("instagram_username")
    @ColumnInfo(name = "user_instagram_username")
    @Expose
    private String instagramUsername;

    @SerializedName("total_collections")
    @ColumnInfo(name = "user_total_collections")
    @Expose
    private Integer totalCollections;

    @SerializedName("total_likes")
    @ColumnInfo(name = "user_total_likes")
    @Expose
    private Integer totalLikes;

    @SerializedName("total_photos")
    @ColumnInfo(name = "user_total_photos")
    @Expose
    private Integer totalPhotos;
    @ColumnInfo(name = "user_accepted_tos")
    @SerializedName("accepted_tos")
    @Expose
    private Boolean acceptedTos;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Links_2 getLinks() {
        return links;
    }

    public void setLinks(Links_2 links) {
        this.links = links;
    }

    public Profile_Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Profile_Image profileImage) {
        this.profileImage = profileImage;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Boolean getAcceptedTos() {
        return acceptedTos;
    }

    public void setAcceptedTos(Boolean acceptedTos) {
        this.acceptedTos = acceptedTos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.updatedAt);
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.twitterUsername);
        dest.writeString(this.portfolioUrl);
        dest.writeString(this.bio);
        dest.writeString(this.location);
        dest.writeParcelable(this.links, flags);
        dest.writeParcelable(this.profileImage, flags);
        dest.writeString(this.instagramUsername);
        dest.writeValue(this.totalCollections);
        dest.writeValue(this.totalLikes);
        dest.writeValue(this.totalPhotos);
        dest.writeValue(this.acceptedTos);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.updatedAt = in.readString();
        this.username = in.readString();
        this.name = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.twitterUsername = in.readString();
        this.portfolioUrl = in.readString();
        this.bio = in.readString();
        this.location = in.readString();
        this.links = in.readParcelable(Links_2.class.getClassLoader());
        this.profileImage = in.readParcelable(Profile_Image.class.getClassLoader());
        this.instagramUsername = in.readString();
        this.totalCollections = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalLikes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalPhotos = (Integer) in.readValue(Integer.class.getClassLoader());
        this.acceptedTos = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
