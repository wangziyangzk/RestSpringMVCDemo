package com.wzy.model;

import java.io.Serializable;
/*
** 用户实体类
 */
public class User implements Serializable {

    private int id;

    private String uname;

    private String passwd;

    private String gentle;

    private String email;

    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getGentle() {
        return gentle;
    }

    public void setGentle(String gentle) {
        this.gentle = gentle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(int id, String uname, String passwd, String gentle, String email, String city) {
        this.id = id;
        this.uname = uname;
        this.passwd = passwd;
        this.gentle = gentle;
        this.email = email;
        this.city = city;
    }
}
