package supermarket.dao.sql;

import supermarket.dao.IStoreDAO;
import supermarket.model.Store;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLStoreDAO extends SQLAbstractDAO implements IStoreDAO {

    public SQLStoreDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public Store get(long id) {
        String query = "SELECT * FROM stores WHERE store_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Store(
                        resultSet.getLong("store_id"),
                        resultSet.getString("address"),
                        resultSet.getString("postal_code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(Store store) {
        String query = "INSERT INTO stores (address, postal_code) VALUES (?, ?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, store.getAddress());
            statement.setString(2, store.getPostalCode());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating store failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Store store) {
        String query = "UPDATE stores SET address = ?, postal_code = ? WHERE store_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, store.getAddress());
            statement.setString(2, store.getPostalCode());
            statement.setLong(3, store.getStoreId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Store store) {
        String query = "DELETE FROM stores WHERE store_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, store.getStoreId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Store> getAll() {
        List<Store> stores = new ArrayList<>();
        String query = "SELECT * FROM stores";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                stores.add(new Store(
                        resultSet.getLong("store_id"),
                        resultSet.getString("address"),
                        resultSet.getString("postal_code")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }
}