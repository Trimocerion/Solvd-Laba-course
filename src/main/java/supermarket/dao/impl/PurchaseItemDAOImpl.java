package supermarket.dao.impl;

import supermarket.dao.PurchaseItemDAO;
import supermarket.model.PurchaseItem;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemDAOImpl implements PurchaseItemDAO {

    private final ConnectionPool connectionPool;

    public PurchaseItemDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public PurchaseItem get(long purchaseId, long productId) {
        String query = "SELECT * FROM Purchase_item WHERE purchase_id = ? AND product_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, purchaseId);
            statement.setLong(2, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new PurchaseItem(
                        resultSet.getLong("purchase_id"),
                        resultSet.getLong("product_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getBigDecimal("price_at_purchase")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PurchaseItem get(long id) {
        return null;
    }

    @Override
    public void save(PurchaseItem purchaseItem) {
        String query = "INSERT INTO Purchase_item (purchase_id, product_id, quantity, price_at_purchase) VALUES (?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, purchaseItem.getPurchaseId());
            statement.setLong(2, purchaseItem.getProductId());
            statement.setInt(3, purchaseItem.getQuantity());
            statement.setBigDecimal(4, purchaseItem.getPriceAtPurchase());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PurchaseItem purchaseItem) {
        String query = "UPDATE Purchase_item SET quantity = ?, price_at_purchase = ? WHERE purchase_id = ? AND product_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, purchaseItem.getQuantity());
            statement.setBigDecimal(2, purchaseItem.getPriceAtPurchase());
            statement.setLong(3, purchaseItem.getPurchaseId());
            statement.setLong(4, purchaseItem.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PurchaseItem purchaseItem) {
        String query = "DELETE FROM Purchase_item WHERE purchase_id = ? AND product_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, purchaseItem.getPurchaseId());
            statement.setLong(2, purchaseItem.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PurchaseItem> getAll() {
        List<PurchaseItem> purchaseItems = new ArrayList<>();
        String query = "SELECT * FROM Purchase_item";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                purchaseItems.add(new PurchaseItem(
                        resultSet.getLong("purchase_id"),
                        resultSet.getLong("product_id"),
                        resultSet.getInt("quantity"),
                        resultSet.getBigDecimal("price_at_purchase")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchaseItems;
    }
}