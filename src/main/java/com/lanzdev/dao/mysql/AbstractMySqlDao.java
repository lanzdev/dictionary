package com.lanzdev.dao.mysql;

import com.lanzdev.dao.ConnectionPool;
import com.lanzdev.dao.GenericDao;
import com.lanzdev.model.Identified;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMySqlDao<T extends Identified<Integer>> implements GenericDao<T> {

    private static final Logger LOGGER = Logger.getLogger(AbstractMySqlDao.class);
    protected Connection connection;

    protected abstract String getInsertQuery( );

    protected abstract String getSelectLastQuery( );

    protected abstract String getSelectByIdQuery( );

    protected abstract String getSelectAllQuery( );

    protected abstract String getUpdateQuery( );

    protected abstract String getDeleteQuery( );

    protected abstract void prepareStatementForCreate(PreparedStatement stmt, T object);

    protected abstract void prepareStatementForUpdate(PreparedStatement stmt, T object);

    protected abstract List<T> parseResultSet(ResultSet rs);

    @Override
    public T create(T object){

        connection = ConnectionPool.getConnection();

        if (object.getId() != null) {
            LOGGER.error("Object already exists.");
        }

        try (PreparedStatement stmt = connection.prepareStatement(
                getInsertQuery())) {
            prepareStatementForCreate(stmt, object);
            int count = stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Exception in create(" + object.getClass().getSimpleName()
                    + " object) during recording: " + e);
        }

        T created = null;

        try (PreparedStatement stmt = connection.prepareStatement(
                getSelectLastQuery())) {

            ResultSet rs = stmt.executeQuery();
            List<T> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                String message = "Exception in create(" + object.getClass().getSimpleName()
                        + " object) during reading last.";
                LOGGER.error(message);
            }
            created = list.iterator().next();

        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }

        return created;
    }

    @Override
    public T get(int key){

        List<T> list = new ArrayList<T>();
        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(
                getSelectByIdQuery())) {

            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }

        if (list == null || list.size() == 0) {
            return null;
        }

        if (list.size() > 1) {
            String message = "Received more than one record.";
            LOGGER.error(message);
        }

        return list.iterator().next();
    }

    @Override
    public List<T> getAll( ) {

        List<T> list = new ArrayList<T>();
        connection = ConnectionPool.getConnection();

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(getSelectAllQuery());
            list = parseResultSet(rs);
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }

        return list;
    }

    @Override
    public void update(T object) {

        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(
                getUpdateQuery())) {

            prepareStatementForUpdate(stmt, object);
            int count = stmt.executeUpdate();
            if (count != 1) {
                String message = "On update modify more then 1 record: " + count + ".";
                LOGGER.error(message);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(T object) {

        connection = ConnectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(
                getDeleteQuery())) {

            stmt.setObject(1, object.getId());
            int count = stmt.executeUpdate();
            if (count != 1) {
                String message = "On delete modify more then 1 record: " + count + ".";
                LOGGER.error(message);
            }
        } catch (Exception e) {
            LOGGER.error("Exception: " + e);
        } finally {
            closeConnection();
        }
    }

    protected void closeConnection( ) {

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("Cannot close connection");
            }
        }
    }
}
