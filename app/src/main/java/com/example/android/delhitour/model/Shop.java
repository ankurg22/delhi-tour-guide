package com.example.android.delhitour.model;

import java.io.Serializable;

/**
 * Created by ankurg22 on 3/8/17.
 */

public class Shop implements Serializable {
    private int mImageId;
    private String mName;
    private String mDetail;

    public Shop(int image, String name, String detail) {
        this.mImageId = image;
        this.mName = name;
        this.mDetail = detail;
    }

    public int getImageId() {
        return mImageId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDetail() {
        return mDetail;
    }
}
