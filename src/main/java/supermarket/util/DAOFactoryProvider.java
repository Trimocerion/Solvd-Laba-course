package supermarket.util;

import javax.sql.DataSource;

import static supermarket.util.DatasourceType.*;

public class DAOFactoryProvider {

    public static IDAOFactory getDAOFactory(DatasourceType type, ConnectionPool datasource) {

        return switch (type) {
            case SQL -> new SQLDAOFactory(datasource);
            //case MONGODB -> new MongoDBDAOFactory();
            default -> throw new IllegalArgumentException("Invalid datasource type");
        };

    }

}
