package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Permission implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -8133912551114090914L;
    private Integer id;
    private String permission;

    public Permission( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getPermission( ) {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString( ) {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
