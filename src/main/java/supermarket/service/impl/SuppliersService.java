package supermarket.service.impl;

import supermarket.model.Suppliers;
import supermarket.service.ISuppliersService;

import java.util.List;

public class SuppliersService implements ISuppliersService {
    private final SuppliersService suppliersDAO;

    public SuppliersService(SuppliersService suppliersDAO) {
        this.suppliersDAO = suppliersDAO;
    }


    @Override
    public Suppliers get(long id) {
        return suppliersDAO.get(id);
    }

    @Override
    public long save(Suppliers suppliers) {
        return suppliersDAO.save(suppliers);
    }

    @Override
    public void update(Suppliers suppliers) {
        suppliersDAO.update(suppliers);
    }

    @Override
    public void delete(Suppliers suppliers) {
        suppliersDAO.delete(suppliers);
    }

    @Override
    public List<Suppliers> getAll() {
        return suppliersDAO.getAll();
    }
}
