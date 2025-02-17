package supermarket.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import supermarket.config.MyBatisConfig;
import supermarket.dao.*;

public class MyBatisDAOFactory implements IDAOFactory{


    private final SqlSessionFactory sqlSessionFactory;

    public MyBatisDAOFactory(){
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public ICheckoutDAO getCheckoutDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(ICheckoutDAO.class);
        }
    }



    @Override
    public ICustomersDAO getCustomersDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(ICustomersDAO.class);
        }
    }

    @Override
    public IPaymentMethodDAO getPaymentMethodDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IPaymentMethodDAO.class);
        }
    }

    @Override
    public IProductCategoriesDAO getProductCategoriesDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IProductCategoriesDAO.class);
        }
    }

    @Override
    public IProductsDAO getProductsDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IProductsDAO.class);
        }
    }

    @Override
    public IPurchaseDAO getPurchaseDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IPurchaseDAO.class);
        }
    }

    @Override
    public IPurchaseItemDAO getPurchaseItemDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IPurchaseItemDAO.class);
        }
    }

    @Override
    public IRolesDAO getRolesDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IRolesDAO.class);
        }
    }

    @Override
    public IStoreDAO getStoreDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IStoreDAO.class);
        }
    }

    @Override
    public ISuppliersDAO getSuppliersDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(ISuppliersDAO.class);
        }
    }

    @Override
    public IUsersDAO getUsersDAO() {
        try(SqlSession session = sqlSessionFactory.openSession())
        {
            return session.getMapper(IUsersDAO.class);
        }
    }
}
