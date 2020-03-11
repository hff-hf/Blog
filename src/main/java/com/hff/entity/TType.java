package com.hff.entity;

import java.util.List;

public class TType {
    private Long tpId;

    private String name;

    private List<TBlog> blogs;

    public TType() {
    }

    public Long getTpId() {
        return tpId;
    }

    public void setTpId(Long tpId) {
        this.tpId = tpId;
    }


    public List<TBlog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<TBlog> blogs) {
        this.blogs = blogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "TType{" +
                "id=" + tpId +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
