package supermarket.service;

import supermarket.model.PurchaseItem;

public interface IPurchaseItemService extends IService<PurchaseItem> {
    PurchaseItem get(long purchaseId, long productId);
}
