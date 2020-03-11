package com.hff.entity;

import java.util.Date;
import java.util.List;

public class TBlog {
    private Long bId;

    private Integer browseTime;

    private String content;

    private Date createTime;

    private String image;

    private String sign;

    private String title;

    private Long typeId;

    private Long userId;

    private TUser user;

    private List<TTag> tags;

    private List<TComment> comments;

    public TBlog() {
    }

    public TBlog(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public TBlog(Long id, String title) {
        this.bId = id;
        this.title = title;
    }



    public TBlog(String content, Date createTime, String image, String sign, String title, Long typeId, Long userId) {
        this.content = content;
        this.createTime = createTime;
        this.image = image;
        this.sign = sign;
        this.title = title;
        this.typeId = typeId;
        this.userId = userId;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }


    public List<TTag> getTags() {
        return tags;
    }

    public List<TComment> getComments() {
        return comments;
    }

    public void setComments(List<TComment> comments) {
        this.comments = comments;
    }

    public void setTags(List<TTag> tags) {
        this.tags = tags;
    }

    public Integer getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(Integer browseTime) {
        this.browseTime = browseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser tUser) {
        this.user = tUser;
    }

    @Override
    public String toString() {
        return "TBlog{" +
                "id=" + bId +
                ", browseTime=" + browseTime +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", image='" + image + '\'' +
                ", sign='" + sign + '\'' +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", user=" + user +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }
}