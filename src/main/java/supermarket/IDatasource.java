package supermarket;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatasource {
    Connection getConnection() throws SQLException;
}
