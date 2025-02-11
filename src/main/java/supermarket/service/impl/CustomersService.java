package supermarket.service.impl;

import supermarket.model.Customer;
import supermarket.service.ICustomersService;

import java.util.List;

public class CustomersService implements ICustomersService {
    private final CustomersService customersDAO;

    public CustomersService(CustomersService customersDAO) {
        this.customersDAO = customersDAO;
    }

    @Override
    public Customer get(long id) {
        return customersDAO.get(id);
    }

    @Override
    public long save(Customer customer) {
        return customersDAO.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customersDAO.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customersDAO.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customersDAO.getAll();
    }
}
