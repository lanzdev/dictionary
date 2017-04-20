package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.UserDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.User;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlUserDao extends AbstractMySqlDao<User>
        implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlUserDao.class);

    private class PersistUser extends User {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_USER;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_USER;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_USER_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_USERS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_USER;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_USER;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, User object) {

        try {
            stmt.setString(1, object.getLogin());
            stmt.setString(2, object.getPassword());
            stmt.setString(3, object.getEmail());
            stmt.setDate(4, object.getDate());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, User object) {

        try {
            stmt.setString(1, object.getLogin());
            stmt.setString(2, object.getPassword());
            stmt.setString(3, object.getEmail());
            stmt.setDate(4, object.getDate());
            stmt.setInt(5, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {

        List<User> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistUser user = new PersistUser();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getDate("date"));
                list.add(user);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
