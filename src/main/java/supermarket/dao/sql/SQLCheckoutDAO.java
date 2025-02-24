package supermarket.dao.sql;

import supermarket.dao.ICheckoutDAO;
import supermarket.model.Checkout;
import supermarket.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCheckoutDAO extends SQLAbstractDAO implements ICheckoutDAO {


    public SQLCheckoutDAO(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public Checkout get(long id) {
        String query = "SELECT * FROM checkout WHERE checkout_id = ?";
        Connection connection = null;
        try{
            connection = getConnectionPool().getConnection();

            try ( PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setLong(1, id);
                try(ResultSet resultSet = statement.executeQuery();){
                    if (resultSet.next()) {
                        return new Checkout(
                                resultSet.getLong("checkout_id"),
                                resultSet.getLong("store_id"),
                                resultSet.getBoolean("is_active")
                        );
                    }
                }
            }
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection != null){
                getConnectionPool().releaseConnection(connection);
            }
        }
        return null;
    }

    @Override
    public long save(Checkout checkout) {
        String query = "INSERT INTO checkout (store_id, is_active) VALUES (?, ?)";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, checkout.getStoreId());
            statement.setBoolean(2, checkout.getIsActive());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                } else {
                    throw new SQLException("Creating payment method failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Checkout checkout) {
        String query = "UPDATE checkout SET store_id = ?, is_active = ? WHERE checkout_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, checkout.getStoreId());
            statement.setBoolean(2, checkout.getIsActive());
            statement.setLong(3, checkout.getCheckoutId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Checkout checkout) {
        String query = "DELETE FROM checkout WHERE checkout_id = ?";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, checkout.getCheckoutId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Checkout> getAll() {
        List<Checkout> checkouts = new ArrayList<>();
        String query = "SELECT * FROM checkout";
        try (Connection connection = getConnectionPool().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                checkouts.add(new Checkout(
                        resultSet.getLong("checkout_id"),
                        resultSet.getLong("store_id"),
                        resultSet.getBoolean("is_active")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkouts;
    }
}