package supermarket.service.impl;

import supermarket.dao.ICheckoutDAO;
import supermarket.model.Checkout;
import supermarket.service.ICheckoutService;

import java.util.List;

public class CheckoutService implements ICheckoutService {

    private final ICheckoutDAO checkoutDAO;

    public CheckoutService(ICheckoutDAO checkoutDAO) {
        this.checkoutDAO = checkoutDAO;
    }

    @Override
    public Checkout get(long id) {
        return checkoutDAO.get(id);
    }

    @Override
    public long save(Checkout checkout) {
        return checkoutDAO.save(checkout);
    }

    @Override
    public void update(Checkout checkout) {
        checkoutDAO.update(checkout);
    }

    @Override
    public void delete(Checkout checkout) {
        checkoutDAO.delete(checkout);
    }

    @Override
    public List<Checkout> getAll() {
        return checkoutDAO.getAll();
    }
}
