package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Suite implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -7833417585033219734L;
    private Integer id;
    private Integer createdBy;
    private String privacy;

    public Suite( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatedBy( ) {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getPrivacy( ) {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString( ) {
        return "Suite{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", privacy='" + privacy + '\'' +
                '}';
    }
}
