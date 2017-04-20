package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.RolePermissionsDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.RolePermissions;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlRolePermissionsDao extends AbstractMySqlDao<RolePermissions>
        implements RolePermissionsDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlRolePermissionsDao.class);

    private class PersistRolePermissions extends RolePermissions {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_ROLE_PERMISSIONS;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_ROLE_PERMISSIONS;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_ROLE_PERMISSION_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_ROLE_PERMISSIONS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_ROLE_PERMISSIONS;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_ROLE_PERMISSIONS;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, RolePermissions object) {

        try {
            stmt.setInt(1, object.getRoleId());
            stmt.setInt(2, object.getPermissionId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, RolePermissions object) {

        try {
            stmt.setInt(1, object.getRoleId());
            stmt.setInt(2, object.getPermissionId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<RolePermissions> parseResultSet(ResultSet rs) {

        List<RolePermissions> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistRolePermissions rolePermissions = new PersistRolePermissions();
                rolePermissions.setId(rs.getInt("role_permissions_id"));
                rolePermissions.setRoleId(rs.getInt("role_id"));
                rolePermissions.setPermissionId(rs.getInt("permission_id"));
                list.add(rolePermissions);
            }

        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
