package com.hff.entity;


public class TBlogTags {
    private Long blogId;

    private Long tagId;


    public TBlogTags() {
    }

    public TBlogTags(Long blogId, Long tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }


    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "TBlogTags{" +
                "blogId=" + blogId +
                ", tagId=" + tagId +
                '}';
    }
}