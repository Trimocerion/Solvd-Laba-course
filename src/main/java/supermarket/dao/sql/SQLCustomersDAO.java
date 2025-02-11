package supermarket.dao.sql;

import supermarket.dao.ICustomersDAO;
import supermarket.model.Customer;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCustomersDAO extends SQLAbstractDAO implements ICustomersDAO {


    public SQLCustomersDAO(ConnectionPool connectionPool)  {
        super(connectionPool);
    }


    @Override
    public Customer get(long id) {
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        Connection connection = null;
        try {
            connection = getConnectionPool().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Customer(
                                resultSet.getLong("customer_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getTime("birth_date"),
                                resultSet.getString("contact_number")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                getConnectionPool().releaseConnection(connection);
            }
        }
        return null;
    }

    @Override
    public long save(Customer customer) {
        String query = "INSERT INTO customers (first_name, last_name, email, birth_date, contact_number) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = getConnectionPool().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, customer.getFirstName());
                statement.setString(2, customer.getLastName());
                statement.setString(3, customer.getEmail());
                statement.setTime(4, customer.getBirthDate());
                statement.setString(5, customer.getContactNumber());
                statement.executeUpdate();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getLong(1);
                    } else {
                        throw new SQLException("Creating customer failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                getConnectionPool().releaseConnection(connection);
            }
        }
    }

    @Override
    public void update(Customer customer) {
        String query = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, contact_number = ? WHERE customer_id = ?";
        Connection connection = null;
        try {
            connection = getConnectionPool().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, customer.getFirstName());
                statement.setString(2, customer.getLastName());
                statement.setString(3, customer.getEmail());
                statement.setString(4, customer.getContactNumber());
                statement.setLong(5, customer.getCustomerId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                getConnectionPool().releaseConnection(connection);
            }
        }
    }

    @Override
    public void delete(Customer customer) {
        String query = "DELETE FROM customers WHERE customer_id = ?";
        Connection connection = null;
        try {
            connection = getConnectionPool().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setLong(1, customer.getCustomerId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                getConnectionPool().releaseConnection(connection);
            }
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";
        Connection connection = null;
        try {
            connection = getConnectionPool().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    customers.add(new Customer(
                            resultSet.getLong("customer_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getTime("birth_date"),
                            resultSet.getString("contact_number")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                getConnectionPool().releaseConnection(connection);
            }
        }
        return customers;
    }
}