package supermarket.service.impl.mybatis;

import supermarket.mapper.IPurchaseMapper;
import supermarket.model.Purchase;
import supermarket.service.IPurchaseService;

import java.util.List;

public class MyBatisPurchaseService implements IPurchaseService {
    private final IPurchaseMapper purchaseMapper;

    public MyBatisPurchaseService(IPurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public Purchase get(long id) {
        return purchaseMapper.get(id);
    }

    @Override
    public long save(Purchase purchase) {
        return purchaseMapper.save(purchase);
    }

    @Override
    public void update(Purchase purchase) {
        purchaseMapper.update(purchase);
    }

    @Override
    public void delete(Purchase purchase) {
        purchaseMapper.delete(purchase.getPurchaseId());
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.getAll();
    }
}
