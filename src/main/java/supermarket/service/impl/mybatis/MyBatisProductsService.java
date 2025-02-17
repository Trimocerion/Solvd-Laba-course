package supermarket.service.impl.mybatis;

import supermarket.mapper.IProductMapper;
import supermarket.model.Product;
import supermarket.service.IProductsService;

import java.util.List;

public class MyBatisProductsService implements IProductsService {

    private final IProductMapper productMapper;

    public MyBatisProductsService(IProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product get(long id) {
        return productMapper.get(id);
    }

    @Override
    public long save(Product product) {
        return productMapper.save(product);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    @Override
    public void delete(Product product) {
        productMapper.delete(product.getProductId());
    }

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }
}
