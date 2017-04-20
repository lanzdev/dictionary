package com.lanzdev.model.entity;

import com.lanzdev.model.Identified;

import java.io.Serializable;

public class UserRoles implements Identified<Integer>, Serializable {


    private static final long serialVersionUID = -3070533078797246758L;
    private Integer id;
    private Integer userId;
    private Integer roleId;

    public UserRoles( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId( ) {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId( ) {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString( ) {
        return "UserRoles{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
