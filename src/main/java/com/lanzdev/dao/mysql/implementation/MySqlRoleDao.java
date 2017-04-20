package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.RoleDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.Role;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlRoleDao extends AbstractMySqlDao<Role>
        implements RoleDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlRoleDao.class);

    private class PersistRole extends Role {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_ROLE;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_ROLE;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_ROLE_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_ROLES;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_ROLE;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_ROLE;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Role object) {

        try {
            stmt.setString(1, object.getRole());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Role object) {

        try {
            stmt.setString(1, object.getRole());
            stmt.setInt(2, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Role> parseResultSet(ResultSet rs) {

        List<Role> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistRole role = new PersistRole();
                role.setId(rs.getInt("role_id"));
                role.setRole(rs.getString("role"));
                list.add(role);
            }

        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
        return list;
    }
}
