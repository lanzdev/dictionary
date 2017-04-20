package com.lanzdev.controllers.managers.mysql.implementation;

import com.lanzdev.controllers.managers.entity.RolePermissionsManager;
import com.lanzdev.dao.entity.RolePermissionsDao;
import com.lanzdev.dao.mysql.implementation.MySqlRolePermissionsDao;
import com.lanzdev.model.entity.RolePermissions;

import java.util.List;

public class MySqlRolePermissionsManager implements RolePermissionsManager {

    private RolePermissionsDao dao = new MySqlRolePermissionsDao();

    @Override
    public RolePermissions add(RolePermissions object) {
        return dao.create(object);
    }

    @Override
    public void update(RolePermissions object) {
        dao.update(object);
    }

    @Override
    public RolePermissions getById(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<RolePermissions> getAll( ) {
        return dao.getAll();
    }
}
