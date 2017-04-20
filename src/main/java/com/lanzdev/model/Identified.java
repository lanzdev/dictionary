package com.lanzdev.model;

import java.io.Serializable;

/**
 * Interface of identified objects
 * @param <PK> primary key type
 */
public interface Identified<PK extends Serializable> {

    /**
     *
     * @return objects identifier
     */
    public PK getId();
}
