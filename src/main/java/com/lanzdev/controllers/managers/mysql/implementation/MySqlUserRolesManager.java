package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.UserRolesManager;
import com.lanzdev.dao.entity.UserRolesDao;
import com.lanzdev.dao.mysql.implementation.MySqlUserRolesDao;
import com.lanzdev.model.entity.UserRoles;

import java.util.List;

public class MySqlUserRolesManager implements UserRolesManager {

    private UserRolesDao dao = new MySqlUserRolesDao();

    @Override
    public UserRoles add(UserRoles object) {
        return dao.create(object);
    }

    @Override
    public void update(UserRoles object) {
        dao.update(object);
    }

    @Override
    public UserRoles getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<UserRoles> getAll( ) {
        return dao.getAll();
    }
}
