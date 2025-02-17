package supermarket.service.impl.mybatis;

import supermarket.mapper.ISupplierMapper;
import supermarket.model.Supplier;
import supermarket.service.ISuppliersService;

import java.util.List;

public class MyBatisSuppliersService implements ISuppliersService {

    private final ISupplierMapper supplierMapper;

    public MyBatisSuppliersService(ISupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }


    @Override
    public Supplier get(long id) {
        return supplierMapper.get(id);
    }

    @Override
    public long save(Supplier supplier) {
        return supplierMapper.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierMapper.update(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        supplierMapper.delete(supplier.getSupplierId());
    }

    @Override
    public List<Supplier> getAll() {
        return supplierMapper.getAll();
    }
}
