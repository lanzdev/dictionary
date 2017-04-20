package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class Antonym implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = -4865397634369813270L;
    private Integer id;
    private String antonym;
    private Integer termId;

    public Antonym( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public String getAntonym( ) {
        return antonym;
    }

    public void setAntonym(String antonym) {
        this.antonym = antonym;
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
                ", antonym='" + antonym + '\'' +
                ", termId=" + termId +
                '}';
    }
}
