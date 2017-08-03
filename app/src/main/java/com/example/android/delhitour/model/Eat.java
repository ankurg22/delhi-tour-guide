package com.example.android.delhitour.model;

import java.io.Serializable;

/**
 * Created by ankurg22 on 3/8/17.
 */

public class Eat implements Serializable {
    private int mImage;
    private String mName;
    private String mWhere;

    public Eat(int image, String name, String where) {
        this.mImage = image;
        this.mName = name;
        this.mWhere = where;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getWhere() {
        return mWhere;
    }

    public int getImage() {
        return mImage;
    }
}
