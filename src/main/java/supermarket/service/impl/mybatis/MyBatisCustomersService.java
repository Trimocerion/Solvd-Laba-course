package supermarket.service.impl.mybatis;

import supermarket.mapper.ICustomerMapper;
import supermarket.model.Customer;
import supermarket.service.ICustomersService;

import java.util.List;

public class MyBatisCustomersService implements ICustomersService {

    private final ICustomerMapper customerMapper;

    public MyBatisCustomersService(ICustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }


    @Override
    public Customer get(long id) {
        return customerMapper.get(id);
    }

    @Override
    public long save(Customer customer) {
        return customerMapper.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerMapper.delete(customer.getCustomerId());
    }

    @Override
    public List<Customer> getAll() {
        return customerMapper.getAll();
    }
}
