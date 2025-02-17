package supermarket.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectionPool {
    private static final int INITIAL_POOL_SIZE = 10;
    private final IDatasource datasource;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections;

    public ConnectionPool(IDatasource datasource) throws SQLException {
        this.datasource = datasource;
        this.connectionPool = Collections.synchronizedList(new ArrayList<>());
        this.usedConnections = Collections.synchronizedList(new ArrayList<>());
        initializePool();
    }



    private void initializePool() throws SQLException {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(datasource.getConnection());
        }
    }

    public Connection getConnection() throws SQLException {
        synchronized (connectionPool) {
            if (connectionPool.isEmpty()) {
                throw new RuntimeException("All connections are in use!");
            }
            Connection connection = connectionPool.remove(connectionPool.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (connectionPool) {
                connectionPool.add(connection);
                usedConnections.remove(connection);
            }
        }
    }

    public int getAvailableConnections() {
        synchronized (connectionPool) {
            return connectionPool.size();
        }
    }
}