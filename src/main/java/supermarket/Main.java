package supermarket;

import supermarket.dao.IStoreDAO;
import supermarket.model.Store;
import supermarket.util.ConnectionPool;
import supermarket.util.MySQLDatasource;
import supermarket.util.SQLDAOFactory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            MySQLDatasource datasource = new MySQLDatasource("jdbc:mysql://localhost:3306/supermarket", "user", "");

            ConnectionPool connectionPool = new ConnectionPool(datasource);

            SQLDAOFactory daoFactory = new SQLDAOFactory(connectionPool);

            IStoreDAO storeDAO = daoFactory.getStoreDAO();

            Store newStore = new Store(0, "123 Main St", "12345");
            long storeId = storeDAO.save(newStore);
            System.out.println("New store created with ID: " + storeId);

            Store retrievedStore = storeDAO.get(storeId);
            System.out.println("Retrieved store: " + retrievedStore);

            retrievedStore.setAddress("456 Elm St");
            storeDAO.update(retrievedStore);
            System.out.println("Store updated");

            storeDAO.delete(retrievedStore);
            System.out.println("Store deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}