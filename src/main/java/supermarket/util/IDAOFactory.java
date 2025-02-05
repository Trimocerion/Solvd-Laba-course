package supermarket.util;

import supermarket.dao.*;

public interface IDAOFactory {
    ICheckoutDAO getCheckoutDAO();
    ICustomersDAO getCustomersDAO();
    IPaymentMethodDAO getPaymentMethodDAO();
    IProductCategoriesDAO getProductCategoriesDAO();
    IProductsDAO getProductsDAO();
    IPurchaseDAO getPurchaseDAO();
    IPurchaseItemDAO getPurchaseItemDAO();
    IRolesDAO getRolesDAO();
    IStoreDAO getStoreDAO();
    ISuppliersDAO getSuppliersDAO();
    IUsersDAO getUsersDAO();
}
