package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.AntonymDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.dao.ConnectionPool;
import com.lanzdev.model.entity.Antonym;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlAntonymDao extends AbstractMySqlDao<Antonym> implements AntonymDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlAntonymDao.class);

    private class PersistAntonym extends Antonym {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    public List<Antonym> getByTermId(Integer id) {

        List<Antonym> list = new ArrayList<>();
        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(Query.SELECT_ANTONYMS_BY_TERM_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }

        return list;
    }

    @Override
    protected String getInsertQuery( ) {
        return Query.INSERT_ANTONYM;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_ANTONYM;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_ANTONYM_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_ANTONYMS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_ANTONYM;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_ANTONYM;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Antonym object) {

        try {
            stmt.setString(1, object.getAntonym());
            stmt.setInt(2, object.getTermId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Antonym object) {

        try {
            stmt.setString(1, object.getAntonym());
            stmt.setInt(2, object.getTermId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Antonym> parseResultSet(ResultSet rs) {

        List<Antonym> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistAntonym antonym = new PersistAntonym();
                antonym.setId(rs.getInt("antonym_id"));
                antonym.setAntonym(rs.getString("antonym"));
                antonym.setTermId(rs.getInt("term_id"));
                list.add(antonym);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
