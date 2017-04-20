package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.TermSuitesManager;
import com.lanzdev.dao.entity.TermSuitesDao;
import com.lanzdev.dao.mysql.implementation.MySqlTermSuitesDao;
import com.lanzdev.model.entity.TermSuites;

import java.util.List;

public class MySqlTermSuitesManager implements TermSuitesManager {

    private TermSuitesDao dao = new MySqlTermSuitesDao();

    @Override
    public TermSuites add(TermSuites object) {
        return dao.create(object);
    }

    @Override
    public void update(TermSuites object) {
        dao.update(object);
    }

    @Override
    public TermSuites getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<TermSuites> getAll( ) {
        return dao.getAll();
    }
}
