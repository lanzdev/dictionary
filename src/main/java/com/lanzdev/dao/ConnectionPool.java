package com.lanzdev.dao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lanz
 */
public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static DataSource dataSource;

    /**
     * Data source without JNDI.
     *
     * @param dataSource specified data source.
     */
    public ConnectionPool(DataSource dataSource) {

        ConnectionPool.dataSource = dataSource;
    }

    /**
     * Get free connection from pool.
     *
     * @return connection.
     */
    public static synchronized Connection getConnection( ) {

        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/dictionary");
            } catch (NamingException e) {
                LOGGER.error("Cannot find the data source");
            }
        }

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("Cannot establish connection");
            return null;
        }
    }

}
