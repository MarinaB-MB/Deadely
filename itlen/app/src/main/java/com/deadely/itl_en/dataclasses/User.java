package com.deadely.itl_en.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User implements Parcelable {
    @NonNull
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public User(String email, Boolean active, String password, String name, List<Stat> stats) {
        this.email = email;
        this.active = active;
        this.password = password;
        this.name = name;
        this.stats = stats;
    }

    public User(String email, Boolean active) {
        this.email = email;
        this.active = active;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.email);
        dest.writeValue(this.active);
        dest.writeString(this.password);
        dest.writeString(this.name);
        dest.writeTypedList(this.stats);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.email = in.readString();
        this.active = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.password = in.readString();
        this.name = in.readString();
        this.stats = in.createTypedArrayList(Stat.CREATOR);
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