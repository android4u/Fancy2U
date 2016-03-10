
package com.meunicorn.fancy2u.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("twitter")
    @Expose
    private String twitter;

    /**
     * 
     * @return
     *     The twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * 
     * @param twitter
     *     The twitter
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
