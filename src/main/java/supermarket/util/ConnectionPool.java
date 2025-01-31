package supermarket.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int INITIAL_POOL_SIZE = 10;
    private final IDatasource datasource;
    private final List<Connection> connectionPool = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    public ConnectionPool(IDatasource datasource) throws SQLException {
        this.datasource = datasource;
        initializePool();
    }

    private void initializePool() throws SQLException {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(datasource.getConnection());
        }
    }

    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("All connections are in use!");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
            return usedConnections.remove(connection);
        }
        return false;
    }

    public int getAvailableConnections() {
        return connectionPool.size();
    }
}
