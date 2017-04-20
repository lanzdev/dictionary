package com.lanzdev.model.entity;


import com.lanzdev.model.Identified;

import java.io.Serializable;

public class TermSuites implements Identified<Integer>, Serializable {

    private static final long serialVersionUID = 7045249403019309279L;
    private Integer id;
    private Integer suiteId;
    private Integer termId;

    public TermSuites( ) {
    }

    public Integer getId( ) {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuiteId( ) {
        return suiteId;
    }

    public void setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
    }

    public Integer getTermId( ) {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    @Override
    public String toString( ) {
        return "TermsSuite{" +
                "id=" + id +
                ", suiteId=" + suiteId +
                ", termId=" + termId +
                '}';
    }
}
