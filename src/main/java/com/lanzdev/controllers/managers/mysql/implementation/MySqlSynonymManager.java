package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.SynonymManager;
import com.lanzdev.dao.entity.SynonymDao;
import com.lanzdev.dao.mysql.implementation.MySqlSynonymDao;
import com.lanzdev.model.entity.Synonym;

import java.util.List;

public class MySqlSynonymManager implements SynonymManager {

    private SynonymDao dao = new MySqlSynonymDao();

    @Override
    public Synonym add(Synonym object) {
        return dao.create(object);
    }

    @Override
    public void update(Synonym object) {
        dao.update(object);
    }

    @Override
    public Synonym getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Synonym> getByTermId(Integer id) {
        return dao.getByTermId(id);
    }

    @Override
    public List<Synonym> getAll( ) {
        return dao.getAll();
    }
}
