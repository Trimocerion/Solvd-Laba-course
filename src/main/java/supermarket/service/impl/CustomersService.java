package supermarket.service.impl;

import supermarket.model.Customers;
import supermarket.service.ICustomersService;

import java.util.List;

public class CustomersService implements ICustomersService {
    private final CustomersService customersDAO;

    public CustomersService(CustomersService customersDAO) {
        this.customersDAO = customersDAO;
    }

    @Override
    public Customers get(long id) {
        return customersDAO.get(id);
    }

    @Override
    public long save(Customers customers) {
        return customersDAO.save(customers);
    }

    @Override
    public void update(Customers customers) {
        customersDAO.update(customers);
    }

    @Override
    public void delete(Customers customers) {
        customersDAO.delete(customers);
    }

    @Override
    public List<Customers> getAll() {
        return customersDAO.getAll();
    }
}
