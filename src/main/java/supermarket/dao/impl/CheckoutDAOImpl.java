package supermarket.dao.impl;

import supermarket.dao.CheckoutDAO;
import supermarket.model.Checkout;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutDAOImpl implements CheckoutDAO {

    private final ConnectionPool connectionPool;

    public CheckoutDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

        @Override
    public Checkout get(long id) {
        String query = "SELECT * FROM checkout WHERE checkout_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Checkout(
                        resultSet.getLong("checkout_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getBoolean("is_active")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Checkout checkout) {
        String query = "INSERT INTO checkout (store_id, is_active) VALUES (?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, checkout.getStoreId());
            statement.setBoolean(2, checkout.isActive());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Checkout checkout) {
        String query = "UPDATE checkout SET store_id = ?, is_active = ? WHERE checkout_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, checkout.getStoreId());
            statement.setBoolean(2, checkout.isActive());
            statement.setLong(3, checkout.getCheckoutId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Checkout checkout) {
        String query = "DELETE FROM checkout WHERE checkout_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, checkout.getCheckoutId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Checkout> getAll() {
        List<Checkout> checkouts = new ArrayList<>();
        String query = "SELECT * FROM checkout";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                checkouts.add(new Checkout(
                        resultSet.getLong("checkout_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getBoolean("is_active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkouts;
    }
}