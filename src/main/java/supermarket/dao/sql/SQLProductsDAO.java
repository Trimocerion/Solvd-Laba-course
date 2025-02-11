package supermarket.dao.sql;

import supermarket.dao.IProductsDAO;
import supermarket.model.Product;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLProductsDAO extends SQLAbstractDAO implements IProductsDAO {

    public SQLProductsDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public Product get(long id) {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Product(
                        resultSet.getLong("product_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getLong("category_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(Product product) {
        String query = "INSERT INTO products (name, description, price, category_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setLong(4, product.getCategoryId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        String query = "UPDATE products SET name = ?, description = ?, price = ?, category_id = ? WHERE product_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setLong(4, product.getCategoryId());
            statement.setLong(5, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, product.getProductId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getLong("product_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getLong("category_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}