package supermarket.util;

import supermarket.dao.*;
import supermarket.dao.sql.*;

public class SQLDAOFactory implements IDAOFactory{

    private final ConnectionPool connectionPool;

    public SQLDAOFactory(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public ICheckoutDAO getCheckoutDAO() {
        return new SQLCheckoutDAO(connectionPool);
    }

    @Override
    public ICustomersDAO getCustomersDAO() {
        return new SQLCustomersDAO(connectionPool);
    }

    @Override
    public IPaymentMethodDAO getPaymentMethodDAO() {
        return new SQLPaymentMethodDAO(connectionPool);
    }

    @Override
    public IProductCategoriesDAO getProductCategoriesDAO() {
        return new SQLProductCategoriesDAO(connectionPool);
    }

    @Override
    public IProductsDAO getProductsDAO() {
        return new SQLProductsDAO(connectionPool);
    }

    @Override
    public IPurchaseDAO getPurchaseDAO() {
        return new SQLPurchaseDAO(connectionPool);
    }

    @Override
    public IPurchaseItemDAO getPurchaseItemDAO() {
        return new SQLPurchaseItemDAO(connectionPool);
    }

    @Override
    public IRolesDAO getRolesDAO() {
        return new SQLRolesDAO(connectionPool);
    }

    @Override
    public IStoreDAO getStoreDAO() {
        return new SQLStoreDAO(connectionPool);
    }

    @Override
    public ISuppliersDAO getSuppliersDAO() {
        return new SQLSuppliersDAO(connectionPool);
    }

    @Override
    public IUsersDAO getUsersDAO() {
        return new SQLUsersDAO(connectionPool);
    }
}
