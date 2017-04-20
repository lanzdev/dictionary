package com.lanzdev.dao.mysql.implementation;

import com.lanzdev.dao.entity.DefinitionDao;
import com.lanzdev.dao.mysql.AbstractMySqlDao;
import com.lanzdev.dao.mysql.Query;
import com.lanzdev.dao.ConnectionPool;
import com.lanzdev.model.entity.Definition;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySqlDefinitionDao extends AbstractMySqlDao<Definition>
        implements DefinitionDao {

    private static final Logger LOGGER = Logger.getLogger(MySqlDefinitionDao.class);

    private class PersistDefinition extends Definition {

        public void setId(Integer id) {
            super.setId(id);
        }
    }

    @Override
    public List<Definition> getByTerm(Integer id) {

        List<Definition> list = new ArrayList<>();
        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(Query.SELECT_DEFINITION_BY_TERM_ID)) {
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
        return Query.INSERT_DEFINITION;
    }

    @Override
    protected String getSelectLastQuery( ) {
        return Query.SELECT_LAST_DEFINITION;
    }

    @Override
    protected String getSelectByIdQuery( ) {
        return Query.SELECT_DEFINITION_BY_ID;
    }

    @Override
    protected String getSelectAllQuery( ) {
        return Query.SELECT_ALL_DEFINITIONS;
    }

    @Override
    protected String getUpdateQuery( ) {
        return Query.UPDATE_DEFINITION;
    }

    @Override
    protected String getDeleteQuery( ) {
        return Query.DELETE_DEFINITION;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Definition object) {

        try {
            stmt.setString(1, object.getDefinition());
            stmt.setInt(2, object.getTermId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Definition object) {

        try {
            stmt.setString(1, object.getDefinition());
            stmt.setInt(2, object.getTermId());
            stmt.setInt(3, object.getId());
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }
    }

    @Override
    protected List<Definition> parseResultSet(ResultSet rs) {

        List<Definition> list = new LinkedList<>();

        try {
            while (rs.next()) {
                PersistDefinition definition = new PersistDefinition();
                definition.setId(rs.getInt("definition_id"));
                definition.setDefinition(rs.getString("definition"));
                definition.setTermId(rs.getInt("term_id"));
                list.add(definition);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        }

        return list;
    }
}
