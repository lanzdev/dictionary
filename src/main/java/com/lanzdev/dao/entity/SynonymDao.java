package com.lanzdev.dao.entity;

import com.lanzdev.dao.GenericDao;
import com.lanzdev.model.entity.Synonym;

import java.util.List;

public interface SynonymDao extends GenericDao<Synonym> {

    List<Synonym> getByTermId(Integer id);
}
