package supermarket.service.impl;

import supermarket.model.ProductCategories;
import supermarket.service.IProductCategoriesService;

import java.util.List;

public class ProductCategoriesService implements IProductCategoriesService {

    private final ProductCategoriesService productCategoriesDao;

    public ProductCategoriesService(ProductCategoriesService productCategoriesDao) {
        this.productCategoriesDao = productCategoriesDao;
    }

    @Override
    public ProductCategories get(long id) {
        return productCategoriesDao.get(id);
    }

    @Override
    public long save(ProductCategories productCategories) {
        return productCategoriesDao.save(productCategories);
    }

    @Override
    public void update(ProductCategories productCategories) {
        productCategoriesDao.update(productCategories);
    }

    @Override
    public void delete(ProductCategories productCategories) {
        productCategoriesDao.delete(productCategories);
    }

    @Override
    public List<ProductCategories> getAll() {
        return productCategoriesDao.getAll();
    }
}
