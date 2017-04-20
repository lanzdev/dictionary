package com.lanzdev.dao.entity;

import com.lanzdev.dao.GenericDao;
import com.lanzdev.model.entity.Definition;

import java.util.List;

public interface DefinitionDao extends GenericDao<Definition> {

    List<Definition> getByTerm(Integer id);
}
