package com.deadely.itl_en.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Lesson implements Parcelable {
    @NonNull
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("checked")
    @Expose
    private Boolean checked;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("words")
    @Expose
    private List<Word> words = null;
    @SerializedName("group")
    @Expose
    private List<Group> group = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public static Creator<Lesson> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeValue(this.checked);
        dest.writeString(this.title);
        dest.writeTypedList(this.words);
        dest.writeList(this.group);
    }

    public Lesson() {
    }

    protected Lesson(Parcel in) {
        this.id = in.readString();
        this.checked = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.title = in.readString();
        this.words = in.createTypedArrayList(Word.CREATOR);
        this.group = new ArrayList<Group>();
        in.readList(this.group, Group.class.getClassLoader());
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel source) {
            return new Lesson(source);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };
}