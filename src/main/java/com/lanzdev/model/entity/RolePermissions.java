package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class RolePermissions implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -4512189766499398947L;
    private Integer id;
    private Integer roleId;
    private Integer permissionId;

    public RolePermissions( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId( ) {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId( ) {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString( ) {
        return "RolePermissions{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
