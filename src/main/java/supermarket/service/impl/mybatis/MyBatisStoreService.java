package supermarket.service.impl.mybatis;

import supermarket.mapper.IStoreMapper;
import supermarket.model.Store;
import supermarket.service.IStoreService;

import java.util.List;

public class MyBatisStoreService implements IStoreService {

    private final IStoreMapper storeMapper;

    public MyBatisStoreService(IStoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public Store get(long id) {
        return storeMapper.get(id);
    }

    @Override
    public long save(Store store) {
        return storeMapper.save(store);
    }

    @Override
    public void update(Store store) {
        storeMapper.update(store);
    }

    @Override
    public void delete(Store store) {
        storeMapper.delete(store.getStoreId());
    }

    @Override
    public List<Store> getAll() {
        return storeMapper.getAll();
    }
}
