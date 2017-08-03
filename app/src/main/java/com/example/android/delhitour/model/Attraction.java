package com.example.android.delhitour.model;

import java.io.Serializable;

/**
 * Created by ankurg22 on 31/7/17.
 */

public class Attraction implements Serializable {
    private int mId;
    private String mName;
    private String mShortDescription;
    private String mLongDescription;
    private int mImageId;

    public Attraction(int id, String name, String shortDesc, String longDesc, int image) {
        this.mId = id;
        this.mName = name;
        this.mShortDescription = shortDesc;
        this.mLongDescription = longDesc;
        mImageId = image;
    }

    public Attraction(int id, String name, String longDesc, int image) {
        this.mId = id;
        this.mName = name;
        this.mLongDescription = longDesc;
        mImageId = image;
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

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public void setLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}
