package com.example.android.delhitour.model;

import java.io.Serializable;

/**
 * Created by ankurg22 on 1/8/17.
 */

public class Activities implements Serializable {
    private int mId;
    private String mName;
    private String mWhat;
    private String mWhen;
    private String mWhere;
    private String mHowMuch;
    private int mImageId;
    private int mColorId;

    public Activities(int id, String name, String what, String when, String where, String howMuch, int image, int color) {
        this.mId = id;
        this.mName = name;
        this.mWhat = what;
        this.mWhen = when;
        this.mWhere = where;
        this.mHowMuch = howMuch;
        this.mImageId = image;
        this.mColorId = color;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getWhat() {
        return mWhat;
    }

    public void setWhat(String mWhat) {
        this.mWhat = mWhat;
    }

    public String getWhen() {
        return mWhen;
    }

    public void setWhen(String mWhen) {
        this.mWhen = mWhen;
    }

    public String getWhere() {
        return mWhere;
    }

    public void setWhere(String mWhere) {
        this.mWhere = mWhere;
    }

    public String getHowMuch() {
        return mHowMuch;
    }

    public void setHowMuch(String mHowMuch) {
        this.mHowMuch = mHowMuch;
    }

    public int getColorId() {
        return mColorId;
    }

    public void setColorId(int mColorId) {
        this.mColorId = mColorId;
    }
}
