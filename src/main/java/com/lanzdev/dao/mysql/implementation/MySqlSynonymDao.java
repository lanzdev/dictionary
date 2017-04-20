package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.ConnectionPool;
import com.lanzdev.dao.entity.SynonymDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.model.entity.Synonym;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlSynonymDao extends AbstractMySqlDao<Synonym>
        implements SynonymDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlSynonymDao.class);

    private class PersistSynonym extends Synonym {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    public List<Synonym> getByTermId(Integer id) {

        List<Synonym> list = new ArrayList<>();
        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(Query.SELECT_SYNONYM_BY_TERM_ID)) {
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
        return Query.INSERT_SYNONYM;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_SYNONYM;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_SYNONYM_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_SYNONYMS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_SYNONYM;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_SYNONYM;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Synonym object) {

        try {
            stmt.setString(1, object.getSynonym());
            stmt.setInt(2, object.getTermId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Synonym object) {

        try {
            stmt.setString(1, object.getSynonym());
            stmt.setInt(2, object.getTermId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Synonym> parseResultSet(ResultSet rs) {

        List<Synonym> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistSynonym synonym = new PersistSynonym();
                synonym.setId(rs.getInt("synonym_id"));
                synonym.setSynonym(rs.getString("synonym"));
                synonym.setTermId(rs.getInt("term_id"));
                list.add(synonym);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
        return list;
    }
}
