package supermarket.dao.mysql;

import supermarket.dao.IUsersDAO;
import supermarket.model.Users;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements IUsersDAO {

    private final ConnectionPool connectionPool;

    public UsersDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Users get(long id) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Users(
                        resultSet.getLong("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getLong("role_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getTime("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Users user) {
        String query = "INSERT INTO users (username, email, password, role_id, store_id, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getRoleId());
            statement.setLong(5, user.getStoreId());
            statement.setTime(6, user.getCreatedAt());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users user) {
        String query = "UPDATE users SET username = ?, email = ?, password = ?, role_id = ?, store_id = ?, created_at = ? WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getRoleId());
            statement.setLong(5, user.getStoreId());
            statement.setTime(6, user.getCreatedAt());
            statement.setLong(7, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Users user) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Users> getAll() {
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new Users(
                        resultSet.getLong("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getLong("role_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getTime("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}