package supermarket;

import supermarket.dao.CheckoutDAO;
import supermarket.dao.impl.CheckoutDAOImpl;
import supermarket.model.Checkout;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            IDatasource datasource = new MySQLDatasource("jdbc:mysql://localhost:3306/supermarket", "root", "");

            ConnectionPool connectionPool = new ConnectionPool(datasource);

            CheckoutDAO checkoutDAO = new CheckoutDAOImpl(connectionPool);

            Checkout checkout = checkoutDAO.get(1);
            System.out.println(checkout);


        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
