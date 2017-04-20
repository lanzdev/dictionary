package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.TermSuitesDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.TermSuites;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlTermSuitesDao extends AbstractMySqlDao<TermSuites>
        implements TermSuitesDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlTermSuitesDao.class);

    private class PersistTermSuites extends TermSuites {

        public void setId(Integer id) {
            super.setId(id);
        }
    }


    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_TERM_SUITES;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_TERM_SUITES;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_TERM_SUITES_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_TERM_SUITES;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_TERM_SUITES;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_TERM_SUITES;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, TermSuites object) {

        try {
            stmt.setInt(1, object.getTermId());
            stmt.setInt(2, object.getSuiteId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, TermSuites object) {

        try {
            stmt.setInt(1, object.getTermId());
            stmt.setInt(2, object.getSuiteId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<TermSuites> parseResultSet(ResultSet rs) {

        List<TermSuites> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistTermSuites termSuites = new PersistTermSuites();
                termSuites.setId(rs.getInt("term_suites_id"));
                termSuites.setTermId(rs.getInt("term_id"));
                termSuites.setSuiteId(rs.getInt("suite_id"));
                list.add(termSuites);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
