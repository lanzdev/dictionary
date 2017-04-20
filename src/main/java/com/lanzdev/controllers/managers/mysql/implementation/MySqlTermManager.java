package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.TermManager;
import com.lanzdev.dao.entity.TermDao;
import com.lanzdev.dao.mysql.implementation.MySqlTermDao;
import com.lanzdev.model.entity.Term;

import java.util.List;

public class MySqlTermManager implements TermManager {

    private TermDao dao = new MySqlTermDao();

    @Override
    public Term add(Term object) {
        return dao.create(object);
    }

    @Override
    public void update(Term object) {
        dao.update(object);
    }

    @Override
    public Term getById(Integer id) {
        return dao.get(id);
    }

    public List<Term> getAll( ) {
        return dao.getAll();
    }
}
