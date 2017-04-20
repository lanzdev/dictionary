package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Term implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -2225095317783351481L;
    private Integer id;
    private String origin;

    public Term( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin( ) {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString( ) {
        return "Term{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                '}';
    }
}
