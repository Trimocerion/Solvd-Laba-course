package supermarket.dao.impl;

import supermarket.dao.StoreDAO;
import supermarket.model.Store;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDAOImpl implements StoreDAO {

    private final ConnectionPool connectionPool;

    public StoreDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Store get(long id) {
        String query = "SELECT * FROM stores WHERE store_id = ?";
        try (Connection connection = connectionPool.getConnection();
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
    public void save(Store store) {
        String query = "INSERT INTO stores (address, postal_code) VALUES (?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, store.getAddress());
            statement.setString(2, store.getPostalCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Store store) {
        String query = "UPDATE stores SET address = ?, postal_code = ? WHERE store_id = ?";
        try (Connection connection = connectionPool.getConnection();
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
        try (Connection connection = connectionPool.getConnection();
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
        try (Connection connection = connectionPool.getConnection();
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