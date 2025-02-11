package supermarket.service.impl;

import supermarket.model.Product;
import supermarket.service.IProductsService;

import java.util.List;

public class ProductsService implements IProductsService {

    private final ProductsService productsDao;

    public ProductsService(ProductsService productsDao) {
        this.productsDao = productsDao;
    }


    @Override
    public Product get(long id) {
        return productsDao.get(id);
    }

    @Override
    public long save(Product product) {
        return productsDao.save(product);
    }

    @Override
    public void update(Product product) {
        productsDao.update(product);
    }

    @Override
    public void delete(Product product) {
        productsDao.delete(product);
    }

    @Override
    public List<Product> getAll() {
        return productsDao.getAll();
    }
}
