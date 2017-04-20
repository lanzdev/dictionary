package com.lanzdev.dao.entity;

import com.lanzdev.dao.GenericDao;
import com.lanzdev.model.entity.Antonym;

import java.util.List;

public interface AntonymDao extends GenericDao<Antonym> {

    List<Antonym> getByTermId(Integer id);
}
