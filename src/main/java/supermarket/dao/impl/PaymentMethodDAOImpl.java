package supermarket.dao.impl;

import supermarket.dao.PaymentMethodDAO;
import supermarket.model.PaymentMethod;
import supermarket.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDAOImpl implements PaymentMethodDAO {

    private final ConnectionPool connectionPool;

    public PaymentMethodDAOImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public PaymentMethod get(long id) {
        String query = "SELECT * FROM payment_method WHERE payment_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new PaymentMethod(
                        resultSet.getLong("payment_id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(PaymentMethod paymentMethod) {
        String query = "INSERT INTO payment_method (name) VALUES (?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, paymentMethod.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PaymentMethod paymentMethod) {
        String query = "UPDATE payment_method SET name = ? WHERE payment_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, paymentMethod.getName());
            statement.setLong(2, paymentMethod.getPaymentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PaymentMethod paymentMethod) {
        String query = "DELETE FROM payment_method WHERE payment_id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, paymentMethod.getPaymentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PaymentMethod> getAll() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        String query = "SELECT * FROM payment_method";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                paymentMethods.add(new PaymentMethod(
                        resultSet.getLong("payment_id"),
                        resultSet.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentMethods;
    }
}