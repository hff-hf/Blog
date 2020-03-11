package com.hff.entity;

import java.util.List;

public class TTag {
    private Long tId;

    private String name;

    private List<TBlogTags> blogTags;


    public TTag() {
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public List<TBlogTags> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<TBlogTags> blogTags) {
        this.blogTags = blogTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "TTag{" +
                "id=" + tId +
                ", name='" + name + '\'' +
                ", blogTags=" + blogTags +
                '}';
    }
}