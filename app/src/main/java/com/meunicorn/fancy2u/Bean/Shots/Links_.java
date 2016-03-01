
package com.meunicorn.fancy2u.Bean.Shots;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Links_ {

    @SerializedName("web")
    @Expose
    private String web;
    @SerializedName("twitter")
    @Expose
    private String twitter;

    /**
     * 
     * @return
     *     The web
     */
    public String getWeb() {
        return web;
    }

    /**
     * 
     * @param web
     *     The web
     */
    public void setWeb(String web) {
        this.web = web;
    }

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
