package supermarket.service.impl;

import supermarket.model.Store;
import supermarket.service.IStoreService;

import java.util.List;

public class StoreService implements IStoreService {
    private final IStoreService storeDAO;

    public StoreService(IStoreService storeDAO) {
        this.storeDAO = storeDAO;
    }

    @Override
    public Store get(long id) {
        return storeDAO.get(id);
    }

    @Override
    public long save(Store store) {
        return storeDAO.save(store);
    }

    @Override
    public void update(Store store) {
        storeDAO.update(store);
    }

    @Override
    public void delete(Store store) {
        storeDAO.delete(store);
    }

    @Override
    public List<Store> getAll() {
        return storeDAO.getAll();
    }
}
