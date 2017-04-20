package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.UserRolesDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.UserRoles;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlUserRolesDao extends AbstractMySqlDao<UserRoles>
        implements UserRolesDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlUserRolesDao.class);

    private class PersistUserRoles extends UserRoles {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_USER_ROLES;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_USER_ROLES;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_USER_ROLES_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_USER_ROLES;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_USER_ROLES;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_USER_ROLES;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, UserRoles object) {

        try {
            stmt.setInt(1, object.getUserId());
            stmt.setInt(2, object.getRoleId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, UserRoles object) {

        try {
            stmt.setInt(1, object.getUserId());
            stmt.setInt(2, object.getRoleId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<UserRoles> parseResultSet(ResultSet rs) {

        List<UserRoles> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistUserRoles userRoles = new PersistUserRoles();
                userRoles.setId(rs.getInt("user_roles_id"));
                userRoles.setUserId(rs.getInt("user_id"));
                userRoles.setRoleId(rs.getInt("role_id"));
                list.add(userRoles);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
