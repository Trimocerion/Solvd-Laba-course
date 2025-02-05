package supermarket.service.impl;


import supermarket.model.PurchaseItem;
import supermarket.service.IPurchaseItemService;

import java.util.List;

public class PurchaseItemService implements IPurchaseItemService {

    private final PurchaseItemService purchaseItemDAO;

    public PurchaseItemService(PurchaseItemService purchaseItemDAO) {
        this.purchaseItemDAO = purchaseItemDAO;
    }


    @Override
    public PurchaseItem get(long purchaseId, long productId) {
        return purchaseItemDAO.get(purchaseId, productId);
    }

    @Override
    public PurchaseItem get(long id) {
        return purchaseItemDAO.get(id);
    }

    @Override
    public long save(PurchaseItem purchaseItem) {
        return purchaseItemDAO.save(purchaseItem);
    }

    @Override
    public void update(PurchaseItem purchaseItem) {
        purchaseItemDAO.update(purchaseItem);
    }

    @Override
    public void delete(PurchaseItem purchaseItem) {
        purchaseItemDAO.delete(purchaseItem);
    }

    @Override
    public List<PurchaseItem> getAll() {
        return purchaseItemDAO.getAll();
    }
}
