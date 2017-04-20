package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.SuiteDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.Suite;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlSuiteDao extends AbstractMySqlDao<Suite>
        implements SuiteDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlSuiteDao.class);

    private class PersistSuite extends Suite {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_SUITE;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_SUITE;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_SUITE_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_SUITES;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_SUITE;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_SUITE;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Suite object) {

        try {
            stmt.setInt(1, object.getCreatedBy());
            stmt.setString(2, object.getPrivacy());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Suite object) {

        try {
            stmt.setInt(1, object.getCreatedBy());
            stmt.setString(2, object.getPrivacy());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Suite> parseResultSet(ResultSet rs) {

        List<Suite> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistSuite suite = new PersistSuite();
                suite.setId(rs.getInt("suite_id"));
                suite.setCreatedBy(rs.getInt("created_by"));
                suite.setPrivacy(rs.getString("privacy"));
                list.add(suite);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
