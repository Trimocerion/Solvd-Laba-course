package supermarket.service.impl.mybatis;

import supermarket.dao.ICheckoutDAO;
import supermarket.mapper.ICheckoutMapper;
import supermarket.mapper.ICustomerMapper;
import supermarket.model.Checkout;
import supermarket.service.ICheckoutService;

import java.util.List;

public class MyBatisCheckoutService implements ICheckoutService {

    private final ICheckoutMapper checkoutMapper;

    public MyBatisCheckoutService(ICheckoutMapper checkoutMapper) {
        this.checkoutMapper = checkoutMapper;
    }

    @Override
    public Checkout get(long id) {
        return checkoutMapper.get(id);
    }

    @Override
    public long save(Checkout checkout) {
        return checkoutMapper.save(checkout);
    }

    @Override
    public void update(Checkout checkout) {
        checkoutMapper.update(checkout);
    }

    @Override
    public void delete(Checkout checkout) {
        checkoutMapper.delete(checkout.getCheckoutId());
    }

    @Override
    public List<Checkout> getAll() {
        return checkoutMapper.getAll();
    }

}
