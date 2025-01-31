package supermarket;

import supermarket.dao.ICheckoutDAO;
import supermarket.dao.mysql.CheckoutDAO;
import supermarket.model.Checkout;
import supermarket.util.ConnectionPool;
import supermarket.util.IDatasource;
import supermarket.util.MySQLDatasource;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            IDatasource datasource = new MySQLDatasource("jdbc:mysql://localhost:3306/supermarket", "root", "");

            ConnectionPool connectionPool = new ConnectionPool(datasource);

            ICheckoutDAO ICheckoutDAO = new CheckoutDAO(connectionPool);

            Checkout checkout = ICheckoutDAO.get(1);
            System.out.println(checkout);


        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
