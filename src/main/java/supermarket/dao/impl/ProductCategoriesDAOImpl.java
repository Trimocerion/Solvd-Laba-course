package supermarket.dao.impl;

import supermarket.dao.ProductCategoriesDAO;
import supermarket.model.ProductCategories;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoriesDAOImpl implements ProductCategoriesDAO {

    private final ConnectionPool connectionPool;

    public ProductCategoriesDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public ProductCategories get(long id) {
        String query = "SELECT * FROM product_category WHERE category_id = ?";
        try (Connection connection = connectionPool.getConnection();
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
    public void save(ProductCategories productCategory) {
        String query = "INSERT INTO product_category (name) VALUES (?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productCategory.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductCategories productCategory) {
        String query = "UPDATE product_category SET name = ? WHERE category_id = ?";
        try (Connection connection = connectionPool.getConnection();
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
        try (Connection connection = connectionPool.getConnection();
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
        try (Connection connection = connectionPool.getConnection();
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