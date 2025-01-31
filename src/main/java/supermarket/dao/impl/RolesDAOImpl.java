package supermarket.dao.impl;

import supermarket.dao.RolesDAO;
import supermarket.model.Roles;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAOImpl implements RolesDAO {

    private final ConnectionPool connectionPool;

    public RolesDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public Roles get(long id) {
        String query = "SELECT * FROM Roles WHERE role_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Roles(
                        resultSet.getLong("role_id"),
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
    public void save(Roles role) {
        String query = "INSERT INTO Roles (name, description) VALUES (?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Roles role) {
        String query = "UPDATE Roles SET name = ?, description = ? WHERE role_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());
            statement.setLong(3, role.getRoleId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Roles role) {
        String query = "DELETE FROM Roles WHERE role_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, role.getRoleId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Roles> getAll() {
        List<Roles> roles = new ArrayList<>();
        String query = "SELECT * FROM Roles";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                roles.add(new Roles(
                        resultSet.getLong("role_id"),
                        resultSet.getString("role_name"),
                        resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}