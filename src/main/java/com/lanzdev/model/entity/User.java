package com.lanzdev.model.entity;

import com.lanzdev.model.Identified;

import java.io.Serializable;
import java.sql.Date;

public class User implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = 4988490369292044131L;
    private Integer id;
    private String  login;
    private String  password;
    private String  email;
    private Date    date;

    public User( ) {

    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getLogin( ) {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword( ) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail( ) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate( ) {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString( ) {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
