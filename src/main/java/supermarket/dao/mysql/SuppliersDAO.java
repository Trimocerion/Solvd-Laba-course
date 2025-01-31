package supermarket.dao.mysql;

import supermarket.dao.ISuppliersDAO;
import supermarket.model.Suppliers;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAO implements ISuppliersDAO {

    private final ConnectionPool connectionPool;

    public SuppliersDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Suppliers get(long id) {
        String query = "SELECT * FROM suppliers WHERE supplier_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Suppliers(
                        resultSet.getLong("supplier_id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact_number"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Suppliers supplier) {
        String query = "INSERT INTO suppliers (name, contact_number, email, address) VALUES (?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getContactNumber());
            statement.setString(3, supplier.getEmail());
            statement.setString(4, supplier.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Suppliers supplier) {
        String query = "UPDATE suppliers SET name = ?, contact_number = ?, email = ?, address = ? WHERE supplier_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getContactNumber());
            statement.setString(3, supplier.getEmail());
            statement.setString(4, supplier.getAddress());
            statement.setLong(5, supplier.getSupplierId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Suppliers supplier) {
        String query = "DELETE FROM suppliers WHERE supplier_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, supplier.getSupplierId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Suppliers> getAll() {
        List<Suppliers> suppliers = new ArrayList<>();
        String query = "SELECT * FROM suppliers";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                suppliers.add(new Suppliers(
                        resultSet.getLong("supplier_id"),
                        resultSet.getString("name"),
                        resultSet.getString("contact_number"),
                        resultSet.getString("email"),
                        resultSet.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}