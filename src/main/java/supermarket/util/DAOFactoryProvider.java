package supermarket.util;

import javax.sql.DataSource;

import static supermarket.util.DatasourceType.*;

public class DAOFactoryProvider {

    private static final ConnectionPool connectionPool;

    static {
        try {
            connectionPool = new ConnectionPool(new MySQLDatasource(
                    "jdbc:mysql://localhost:3306/supermarket",
                    "root",
                    ""
            ));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize connection pool", e);
        }
    }


    public static IDAOFactory getDAOFactory(DatasourceType type) {

        return switch (type) {
            case SQL -> new SQLDAOFactory(connectionPool);
            case MYBATIS -> new MyBatisDAOFactory();
            //case MONGODB -> new MongoDBDAOFactory();
            default -> throw new IllegalArgumentException("Invalid datasource type");
        };

    }

}
