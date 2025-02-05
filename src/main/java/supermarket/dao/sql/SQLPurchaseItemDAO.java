package supermarket.dao.sql;

import supermarket.dao.IPurchaseItemDAO;
import supermarket.model.PurchaseItem;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPurchaseItemDAO extends SQLAbstractDAO implements IPurchaseItemDAO {

    public SQLPurchaseItemDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public PurchaseItem get(long purchaseId, long productId) {
        String query = "SELECT * FROM Purchase_item WHERE purchase_id = ? AND product_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
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
    public long save(PurchaseItem purchaseItem) {
        String query = "INSERT INTO Purchase_item (purchase_id, product_id, quantity, price_at_purchase) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, purchaseItem.getPurchaseId());
            statement.setLong(2, purchaseItem.getProductId());
            statement.setInt(3, purchaseItem.getQuantity());
            statement.setBigDecimal(4, purchaseItem.getPriceAtPurchase());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating purchase item failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PurchaseItem purchaseItem) {
        String query = "UPDATE Purchase_item SET quantity = ?, price_at_purchase = ? WHERE purchase_id = ? AND product_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
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
        try (Connection connection = getConnectionPool().getConnection();
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
        try (Connection connection = getConnectionPool().getConnection();
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