package supermarket.service.impl;

import supermarket.model.Products;
import supermarket.service.IProductsService;

import java.util.List;

public class ProductsService implements IProductsService {

    private final ProductsService productsDao;

    public ProductsService(ProductsService productsDao) {
        this.productsDao = productsDao;
    }


    @Override
    public Products get(long id) {
        return productsDao.get(id);
    }

    @Override
    public long save(Products products) {
        return productsDao.save(products);
    }

    @Override
    public void update(Products products) {
        productsDao.update(products);
    }

    @Override
    public void delete(Products products) {
        productsDao.delete(products);
    }

    @Override
    public List<Products> getAll() {
        return productsDao.getAll();
    }
}
