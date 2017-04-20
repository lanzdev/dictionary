package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Role implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = 2456625564848449429L;
    private Integer id;
    private String role;

    public Role( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getRole( ) {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString( ) {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
