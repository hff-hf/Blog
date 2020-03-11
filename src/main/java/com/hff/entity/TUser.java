package com.hff.entity;

import java.util.List;

public class TUser {
    private Long usId;

    private String email;

    private String nickName;

    private String password;

    private String userName;

    private String head;

    private List<TBlog> blogs;

    public TUser() {
    }

    public TUser( String email, String nickName, String password, String userName,String head) {
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.userName = userName;
        this.head = head;
    }

    public TUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Long getUsId() {
        return usId;
    }

    public void setUsId(Long usId) {
        this.usId = usId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public List<TBlog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<TBlog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "usId=" + usId +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", head='" + head + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}