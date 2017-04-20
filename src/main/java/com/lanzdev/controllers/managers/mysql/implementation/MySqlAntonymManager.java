package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.AntonymManager;
import com.lanzdev.dao.entity.AntonymDao;
import com.lanzdev.dao.mysql.implementation.MySqlAntonymDao;
import com.lanzdev.model.entity.Antonym;

import java.util.List;

public class MySqlAntonymManager implements AntonymManager {

    private AntonymDao dao = new MySqlAntonymDao();

    @Override
    public Antonym add(Antonym object) {
        return dao.create(object);
    }

    @Override
    public void update(Antonym object) {
        dao.update(object);
    }

    @Override
    public Antonym getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Antonym> getByTermId(Integer id) {
        return dao.getByTermId(id);
    }

    @Override
    public List<Antonym> getAll( ) {
        return dao.getAll();
    }
}
