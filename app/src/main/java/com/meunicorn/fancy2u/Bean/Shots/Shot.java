
package com.meunicorn.fancy2u.Bean.Shots;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Shot implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("attachments_count")
    @Expose
    private Integer attachmentsCount;
    @SerializedName("rebounds_count")
    @Expose
    private Integer reboundsCount;
    @SerializedName("buckets_count")
    @Expose
    private Integer bucketsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("attachments_url")
    @Expose
    private String attachmentsUrl;
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;
    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;
    @SerializedName("rebounds_url")
    @Expose
    private String reboundsUrl;
    @SerializedName("animated")
    @Expose
    private Boolean animated;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("rebound_source_url")
    @Expose
    private String reboundSourceUrl;

    protected Shot(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        images = in.readParcelable(Images.class.getClassLoader());
        createdAt = in.readString();
        updatedAt = in.readString();
        htmlUrl = in.readString();
        attachmentsUrl = in.readString();
        bucketsUrl = in.readString();
        commentsUrl = in.readString();
        likesUrl = in.readString();
        projectsUrl = in.readString();
        reboundsUrl = in.readString();
        tags = in.createStringArrayList();
        reboundSourceUrl = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        viewsCount = in.readInt();
        likesCount = in.readInt();
        commentsCount = in.readInt();
//        images=in.readParcelable(Images.class.getClassLoader());


    }

    public static final Creator<Shot> CREATOR = new Creator<Shot>() {
        @Override
        public Shot createFromParcel(Parcel in) {
            return new Shot(in);
        }

        @Override
        public Shot[] newArray(int size) {
            return new Shot[size];
        }
    };

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return The images
     */
    public Images getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     * @return The viewsCount
     */
    public Integer getViewsCount() {
        return viewsCount;
    }

    /**
     * @param viewsCount The views_count
     */
    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     * @return The likesCount
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     * @param likesCount The likes_count
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    /**
     * @return The commentsCount
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * @param commentsCount The comments_count
     */
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * @return The attachmentsCount
     */
    public Integer getAttachmentsCount() {
        return attachmentsCount;
    }

    /**
     * @param attachmentsCount The attachments_count
     */
    public void setAttachmentsCount(Integer attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }

    /**
     * @return The reboundsCount
     */
    public Integer getReboundsCount() {
        return reboundsCount;
    }

    /**
     * @param reboundsCount The rebounds_count
     */
    public void setReboundsCount(Integer reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    /**
     * @return The bucketsCount
     */
    public Integer getBucketsCount() {
        return bucketsCount;
    }

    /**
     * @param bucketsCount The buckets_count
     */
    public void setBucketsCount(Integer bucketsCount) {
        this.bucketsCount = bucketsCount;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return The attachmentsUrl
     */
    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }

    /**
     * @param attachmentsUrl The attachments_url
     */
    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }

    /**
     * @return The bucketsUrl
     */
    public String getBucketsUrl() {
        return bucketsUrl;
    }

    /**
     * @param bucketsUrl The buckets_url
     */
    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }

    /**
     * @return The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     * @param commentsUrl The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     * @return The likesUrl
     */
    public String getLikesUrl() {
        return likesUrl;
    }

    /**
     * @param likesUrl The likes_url
     */
    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    /**
     * @return The projectsUrl
     */
    public String getProjectsUrl() {
        return projectsUrl;
    }

    /**
     * @param projectsUrl The projects_url
     */
    public void setProjectsUrl(String projectsUrl) {
        this.projectsUrl = projectsUrl;
    }

    /**
     * @return The reboundsUrl
     */
    public String getReboundsUrl() {
        return reboundsUrl;
    }

    /**
     * @param reboundsUrl The rebounds_url
     */
    public void setReboundsUrl(String reboundsUrl) {
        this.reboundsUrl = reboundsUrl;
    }

    /**
     * @return The animated
     */
    public Boolean getAnimated() {
        return animated;
    }

    /**
     * @param animated The animated
     */
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     * @return The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team The team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * @return The reboundSourceUrl
     */
    public String getReboundSourceUrl() {
        return reboundSourceUrl;
    }

    /**
     * @param reboundSourceUrl The rebound_source_url
     */
    public void setReboundSourceUrl(String reboundSourceUrl) {
        this.reboundSourceUrl = reboundSourceUrl;
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeParcelable(images, flags);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(htmlUrl);
        dest.writeString(attachmentsUrl);
        dest.writeString(bucketsUrl);
        dest.writeString(commentsUrl);
        dest.writeString(likesUrl);
        dest.writeString(projectsUrl);
        dest.writeString(reboundsUrl);
        dest.writeStringList(tags);
        dest.writeString(reboundSourceUrl);
        dest.writeParcelable(user, flags);
        dest.writeInt(viewsCount);
        dest.writeInt(likesCount);
        dest.writeInt(commentsCount);
    }

}
