package com.deadely.itl_en.dataclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Word implements Parcelable {
    @NonNull
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("tr")
    @Expose
    private String tr;
    @SerializedName("checked")
    @Expose
    private Boolean checked;
    @SerializedName("translate")
    @Expose
    private String translate;
    @SerializedName("lesson")
    @Expose
    private List<Lesson> lesson = null;
    @SerializedName("group")
    @Expose
    private List<Group> group = null;
    @SerializedName("_created")
    @Expose
    private String created;
    @SerializedName("_changed")
    @Expose
    private String changed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.word);
        dest.writeString(this.tr);
        dest.writeValue(this.checked);
        dest.writeString(this.translate);
        dest.writeList(this.lesson);
        dest.writeList(this.group);
        dest.writeString(this.created);
        dest.writeString(this.changed);
    }

    public Word() {
    }

    protected Word(Parcel in) {
        this.id = in.readString();
        this.word = in.readString();
        this.tr = in.readString();
        this.checked = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.translate = in.readString();
        this.lesson = new ArrayList<Lesson>();
        in.readList(this.lesson, Lesson.class.getClassLoader());
        this.group = new ArrayList<Group>();
        in.readList(this.group, Group.class.getClassLoader());
        this.created = in.readString();
        this.changed = in.readString();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel source) {
            return new Word(source);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };
}