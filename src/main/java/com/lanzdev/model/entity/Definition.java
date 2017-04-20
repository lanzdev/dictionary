package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Definition implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = 8969161993586152841L;
    private Integer id;
    private String definition;
    private Integer termId;

    public Definition( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getDefinition( ) {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Integer getTermId( ) {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    @Override
    public String toString( ) {
        return "Definition{" +
                "id=" + id +
                ", definition='" + definition + '\'' +
                ", termId=" + termId +
                '}';
    }
}
