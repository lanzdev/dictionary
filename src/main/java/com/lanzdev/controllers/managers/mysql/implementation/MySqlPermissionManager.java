package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.PermissionManager;
import com.lanzdev.dao.entity.PermissionDao;
import com.lanzdev.dao.mysql.implementation.MySqlPermissionDao;
import com.lanzdev.model.entity.Permission;

import java.util.List;

public class MySqlPermissionManager implements PermissionManager {

    private PermissionDao dao = new MySqlPermissionDao();

    @Override
    public Permission add(Permission object) {
        return dao.create(object);
    }

    @Override
    public void update(Permission object) {
        dao.update(object);
    }

    @Override
    public Permission getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Permission> getAll( ) {
        return dao.getAll();
    }
}
