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

import java.util.List;

@Entity(tableName = "photo_table")
public class Photo implements Parcelable {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "photo_id")
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @ColumnInfo(name = "photo_updated_at")
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("promoted_at")
    @Expose
    private String promotedAt;

    @SerializedName("width")
    @Expose
    private Integer width;

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("alt_description")
    @Expose
    private String altDescription;

    @Embedded
    @SerializedName("urls")
    @Expose
    private Urls urls;

    @Embedded(prefix = "+")
    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("categories")
    @Expose
    private List<String> categories = null;

    @SerializedName("likes")
    @ColumnInfo(name = "photo_likes")
    @Expose
    private Integer likes;

    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;

    @SerializedName("current_user_collections")
    @Expose
    private List<String> currentUserCollections = null;

    @SerializedName("sponsorship")
    @Embedded
    @Expose
    private Sponsorship sponsorship;

    @Embedded
    @SerializedName("user")
    @Expose
    private User user;

    public Photo() {
    }

    protected Photo(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        promotedAt = in.readString();
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readInt();
        }
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        color = in.readString();
        description = in.readString();
        altDescription = in.readString();
        urls = in.readParcelable(Urls.class.getClassLoader());
        links = in.readParcelable(Links.class.getClassLoader());
        categories = in.createStringArrayList();
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        byte tmpLikedByUser = in.readByte();
        likedByUser = tmpLikedByUser == 0 ? null : tmpLikedByUser == 1;
        currentUserCollections = in.createStringArrayList();
        sponsorship = in.readParcelable(Sponsorship.class.getClassLoader());
        user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPromotedAt() {
        return promotedAt;
    }

    public void setPromotedAt(String promotedAt) {
        this.promotedAt = promotedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<String> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<String> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Sponsorship getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Sponsorship sponsorship) {
        this.sponsorship = sponsorship;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(promotedAt);
        if (width == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(width);
        }
        if (height == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(height);
        }
        dest.writeString(color);
        dest.writeString(description);
        dest.writeString(altDescription);
        dest.writeParcelable(urls, flags);
        dest.writeParcelable(links, flags);
        dest.writeStringList(categories);
        if (likes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(likes);
        }
        dest.writeByte((byte) (likedByUser == null ? 0 : likedByUser ? 1 : 2));
        dest.writeStringList(currentUserCollections);
        dest.writeParcelable(sponsorship, flags);
        dest.writeParcelable(user, flags);
    }
}
