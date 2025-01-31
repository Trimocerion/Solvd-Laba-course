package supermarket.dao;

import supermarket.model.PurchaseItem;

import java.util.List;

public interface PurchaseItemDAO extends DAO<PurchaseItem> {
    PurchaseItem get(long purchaseId, long productId);
    void save(PurchaseItem purchaseItem);
    void update(PurchaseItem purchaseItem);
    void delete(PurchaseItem purchaseItem);
    List<PurchaseItem> getAll();
}