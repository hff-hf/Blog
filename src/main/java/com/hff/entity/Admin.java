package com.hff.entity;

/**
 * @auther hff
 * @time 2020/3/3 - 18:52
 **/
public class Admin {

    private Integer id;
    private String adminName;
    private String password;
    private String image;
    private boolean sex;

    public Admin() {
    }

    public Admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public Admin(Integer id, String adminName, String password, String image, boolean sex) {
        this.id = id;
        this.adminName = adminName;
        this.password = password;
        this.image = image;
        this.sex = sex;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", sex=" + sex +
                '}';
    }
}
