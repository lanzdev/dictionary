package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.RoleManager;
import com.lanzdev.dao.entity.RoleDao;
import com.lanzdev.dao.mysql.implementation.MySqlRoleDao;
import com.lanzdev.model.entity.Role;

import java.util.List;

public class MySqlRoleManager implements RoleManager {

    private RoleDao dao = new MySqlRoleDao();

    @Override
    public Role add(Role object) {
        return dao.create(object);
    }

    @Override
    public void update(Role object) {
        dao.update(object);
    }

    @Override
    public Role getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Role> getAll( ) {
        return dao.getAll();
    }
}
