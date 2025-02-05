package supermarket.dao.sql;

import supermarket.dao.IProductCategoriesDAO;
import supermarket.model.ProductCategories;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLProductCategoriesDAO extends SQLAbstractDAO implements IProductCategoriesDAO {

    public SQLProductCategoriesDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public ProductCategories get(long id) {
        String query = "SELECT * FROM product_category WHERE category_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new ProductCategories(
                        resultSet.getLong("category_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(ProductCategories productCategory) {
        String query = "INSERT INTO product_category (name) VALUES (?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, productCategory.getName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating product category failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ProductCategories productCategory) {
        String query = "UPDATE product_category SET name = ? WHERE category_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productCategory.getName());
            statement.setLong(2, productCategory.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ProductCategories productCategory) {
        String query = "DELETE FROM product_category WHERE category_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, productCategory.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductCategories> getAll() {
        List<ProductCategories> productCategories = new ArrayList<>();
        String query = "SELECT * FROM product_category";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                productCategories.add(new ProductCategories(
                        resultSet.getLong("category_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productCategories;
    }
}