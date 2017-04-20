package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.TermDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.Term;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MySqlTermDao extends AbstractMySqlDao<Term> implements TermDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlTermDao.class);

    private class PersistTerm extends Term {

        @Override
        protected void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_TERM;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_TERM;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_TERM_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_TERMS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_TERM;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_TERM;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Term object) {

        try {
            stmt.setString(1, object.getOrigin());
        } catch (SQLException e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Term object) {

        try {
            stmt.setString(1, object.getOrigin());
            stmt.setInt(2, object.getId());
        } catch (SQLException e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Term> parseResultSet(ResultSet rs) {

        LinkedList<Term> list = new LinkedList<>();
        try {
            while (rs.next()) {
                PersistTerm term = new PersistTerm();
                term.setId(rs.getInt("term_id"));
                term.setOrigin(rs.getString("origin"));
                list.add(term);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
