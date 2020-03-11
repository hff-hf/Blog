package com.hff.entity;

import java.util.Date;

public class TComment {
    private Long cId;

    private String content;

    private Date createTime;

    private String email;

    private String nickName;

    private String head;

    private Long blogId;

    private TBlog blog;

    public TComment() {
    }

    public TComment(String content, Date creatTime, String nickName, Long blogId ,String head) {
        this.content = content;
        this.createTime = creatTime;
        this.nickName = nickName;
        this.blogId = blogId;
        this.head=head;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public TBlog getBlog() {
        return blog;
    }

    public void setBlog(TBlog blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatTime() {
        return createTime;
    }

    public void setCreatTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "TComment{" +
                "id=" + cId +
                ", content='" + content + '\'' +
                ", creatTime=" + createTime +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", blogId=" + blogId +
                ", blog=" + blog +
                '}';
    }
}