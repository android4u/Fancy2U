
package com.meunicorn.fancy2u.Bean.Shots;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Parcelable {

    @SerializedName("hidpi")
    @Expose
    private String hidpi;
    @SerializedName("normal")
    @Expose
    private String normal;
    @SerializedName("teaser")
    @Expose
    private String teaser;

    protected Images(Parcel in) {
        hidpi = in.readString();
        normal = in.readString();
        teaser = in.readString();
    }


    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    /**
     * 
     * @return
     *     The hidpi
     */
    public String getHidpi() {
        return hidpi;
    }

    /**
     * 
     * @param hidpi
     *     The hidpi
     */
    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    /**
     * 
     * @return
     *     The normal
     */
    public String getNormal() {
        return normal;
    }

    /**
     * 
     * @param normal
     *     The normal
     */
    public void setNormal(String normal) {
        this.normal = normal;
    }

    /**
     * 
     * @return
     *     The teaser
     */
    public String getTeaser() {
        return teaser;
    }

    /**
     * 
     * @param teaser
     *     The teaser
     */
    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hidpi);
        dest.writeString(normal);
        dest.writeString(teaser);
    }
}

