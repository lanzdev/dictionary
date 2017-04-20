package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.SuiteManager;
import com.lanzdev.dao.entity.SuiteDao;
import com.lanzdev.dao.mysql.implementation.MySqlSuiteDao;
import com.lanzdev.model.entity.Suite;

import java.util.List;

public class MySqlSuiteManager implements SuiteManager{

    private SuiteDao dao = new MySqlSuiteDao();

    @Override
    public Suite add(Suite object) {
        return dao.create(object);
    }

    @Override
    public void update(Suite object) {
        dao.update(object);
    }

    @Override
    public Suite getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Suite> getAll( ) {
        return dao.getAll();
    }
}
