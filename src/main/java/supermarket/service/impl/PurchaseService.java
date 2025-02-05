package supermarket.service.impl;

import supermarket.model.Purchase;
import supermarket.service.IPurchaseService;

import java.util.List;

public class PurchaseService implements IPurchaseService {

    private final PurchaseService purchaseDAO;

    public PurchaseService(PurchaseService purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }


    @Override
    public Purchase get(long id) {
        return purchaseDAO.get(id);
    }

    @Override
    public long save(Purchase purchase) {
        return purchaseDAO.save(purchase);
    }

    @Override
    public void update(Purchase purchase) {
        purchaseDAO.update(purchase);
    }

    @Override
    public void delete(Purchase purchase) {
        purchaseDAO.delete(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseDAO.getAll();
    }
}
