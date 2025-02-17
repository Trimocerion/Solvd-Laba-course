package supermarket.service.impl.mybatis;

import supermarket.mapper.IProductCategoryMapper;
import supermarket.model.ProductCategories;
import supermarket.service.IProductCategoriesService;

import java.util.List;

public class MyBatisProductCategoriesService implements IProductCategoriesService {

    private final IProductCategoryMapper productCategoryMapper;

    public MyBatisProductCategoriesService(IProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public ProductCategories get(long id) {
        return productCategoryMapper.get(id);
    }

    @Override
    public long save(ProductCategories productCategories) {
        return productCategoryMapper.save(productCategories);
    }

    @Override
    public void update(ProductCategories productCategories) {
        productCategoryMapper.update(productCategories);
    }

    @Override
    public void delete(ProductCategories productCategories) {
        productCategoryMapper.delete(productCategories.getCategoryId());
    }

    @Override
    public List<ProductCategories> getAll() {
        return productCategoryMapper.getAll();
    }
}
