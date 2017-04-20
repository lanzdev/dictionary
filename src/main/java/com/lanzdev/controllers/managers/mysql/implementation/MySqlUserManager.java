package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.UserManager;
import com.lanzdev.dao.entity.UserDao;
import com.lanzdev.dao.mysql.implementation.MySqlUserDao;
import com.lanzdev.model.entity.User;

import java.util.List;

public class MySqlUserManager implements UserManager {

    private UserDao dao = new MySqlUserDao();

    @Override
    public User add(User object) {
        return dao.create(object);
    }

    @Override
    public void update(User object) {
        dao.update(object);
    }

    @Override
    public User getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<User> getAll( ) {
        return dao.getAll();
    }
}
