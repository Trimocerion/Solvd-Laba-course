package supermarket.service.impl;

import supermarket.model.Supplier;
import supermarket.service.ISuppliersService;

import java.util.List;

public class SuppliersService implements ISuppliersService {
    private final SuppliersService suppliersDAO;

    public SuppliersService(SuppliersService suppliersDAO) {
        this.suppliersDAO = suppliersDAO;
    }


    @Override
    public Supplier get(long id) {
        return suppliersDAO.get(id);
    }

    @Override
    public long save(Supplier supplier) {
        return suppliersDAO.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        suppliersDAO.update(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        suppliersDAO.delete(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return suppliersDAO.getAll();
    }
}
