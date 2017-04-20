package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.DefinitionManager;
import com.lanzdev.dao.entity.DefinitionDao;
import com.lanzdev.dao.mysql.implementation.MySqlDefinitionDao;
import com.lanzdev.model.entity.Definition;

import java.util.List;

public class MySqlDefinitionManager implements DefinitionManager {

    private DefinitionDao dao = new MySqlDefinitionDao();

    @Override
    public Definition add(Definition object) {
        return dao.create(object);
    }

    @Override
    public void update(Definition object) {
        dao.update(object);
    }

    @Override
    public Definition getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Definition> getByTermId(Integer id) {
        return dao.getByTerm(id);
    }

    @Override
    public List<Definition> getAll( ) {
        return dao.getAll();
    }
}
