package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Synonym implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -8978131970160253572L;
    private Integer id;
    private String synonym;
    private Integer termId;

    public Synonym( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getSynonym( ) {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public Integer getTermId( ) {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    @Override
    public String toString( ) {
        return "Synonym{" +
                "id=" + id +
                ", synonym='" + synonym + '\'' +
                ", termId=" + termId +
                '}';
    }
}
