package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.PermissionDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.Permission;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlPermissionDao extends AbstractMySqlDao<Permission>
        implements PermissionDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlPermissionDao.class);

    private class PersistPermission extends Permission {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_PERMISSION;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_PERMISSION;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_PERMISSION_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_PERMISSIONS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_PERMISSION;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_PERMISSION;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Permission object) {

        try {
            stmt.setString(1, object.getPermission());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Permission object) {

        try {
            stmt.setString(1, object.getPermission());
            stmt.setInt(2, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Permission> parseResultSet(ResultSet rs) {

        List<Permission> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistPermission permission = new PersistPermission();
                permission.setId(rs.getInt("permission_id"));
                permission.setPermission(rs.getString("permission"));
                list.add(permission);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
        return list;
    }
}
