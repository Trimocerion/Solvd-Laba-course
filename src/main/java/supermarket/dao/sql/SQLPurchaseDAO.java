package supermarket.dao.sql;

import supermarket.dao.IPurchaseDAO;
import supermarket.model.Purchase;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPurchaseDAO extends SQLAbstractDAO implements IPurchaseDAO {

    public SQLPurchaseDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public Purchase get(long id) {
        String query = "SELECT * FROM purchase WHERE purchase_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Purchase(
                        resultSet.getLong("purchase_id"),
                        resultSet.getLong("payment_method_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getLong("checkout_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getLong("user_id"),
                        resultSet.getTime("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(Purchase purchase) {
        String query = "INSERT INTO Purchase (payment_method_id, customer_id, checkout_id, store_id, user_id, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, purchase.getPaymentMethodId());
            statement.setLong(2, purchase.getCustomerId());
            statement.setLong(3, purchase.getCheckoutId());
            statement.setLong(4, purchase.getStoreId());
            statement.setLong(5, purchase.getUserId());
            statement.setTimestamp(6, new java.sql.Timestamp(purchase.getCreatedAt().getTime()));
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating payment method failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Purchase purchase) {
        String query = "UPDATE Purchase SET payment_method_id = ?, customer_id = ?, checkout_id = ?, store_id = ?, user_id = ?, created_at = ? WHERE purchase_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, purchase.getPaymentMethodId());
            statement.setLong(2, purchase.getCustomerId());
            statement.setLong(3, purchase.getCheckoutId());
            statement.setLong(4, purchase.getStoreId());
            statement.setLong(5, purchase.getUserId());
            statement.setTimestamp(6, new java.sql.Timestamp(purchase.getCreatedAt().getTime()));
            statement.setLong(7, purchase.getPurchaseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Purchase purchase) {
        String query = "DELETE FROM Purchase WHERE purchase_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, purchase.getPurchaseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Purchase> getAll() {
        List<Purchase> purchases = new ArrayList<>();
        String query = "SELECT * FROM Purchase";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                purchases.add(new Purchase(
                        resultSet.getLong("purchase_id"),
                        resultSet.getLong("payment_method_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getLong("checkout_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getLong("user_id"),
                        resultSet.getTime("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchases;
    }
}