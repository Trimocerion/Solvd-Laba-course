package supermarket.dao.sql;

import supermarket.util.ConnectionPool;

public abstract class SQLAbstractDAO {

    private final ConnectionPool connectionPool;

    protected SQLAbstractDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
