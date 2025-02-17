package supermarket.service.impl.mybatis;

import supermarket.mapper.IPurchaseItemMapper;
import supermarket.model.PurchaseItem;
import supermarket.service.IPurchaseItemService;

import java.util.List;

public class MyBatisPurchaseItemService implements IPurchaseItemService {


    private final IPurchaseItemMapper purchaseItemMapper;

    public MyBatisPurchaseItemService(IPurchaseItemMapper purchaseItemMapper) {
        this.purchaseItemMapper = purchaseItemMapper;
    }

    @Override
    public PurchaseItem get(long purchaseId, long productId) {
        return purchaseItemMapper.get(purchaseId, productId);
    }

    @Override
    public PurchaseItem get(long id) {
        return purchaseItemMapper.get(id);
    }

    @Override
    public long save(PurchaseItem purchaseItem) {
        return purchaseItemMapper.save(purchaseItem);
    }

    @Override
    public void update(PurchaseItem purchaseItem) {

    }

    @Override
    public void delete(PurchaseItem purchaseItem) {

    }

    @Override
    public List<PurchaseItem> getAll() {
        return List.of();
    }
}
