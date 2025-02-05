package supermarket.service.impl;

import supermarket.dao.IPaymentMethodDAO;
import supermarket.model.PaymentMethod;
import supermarket.service.IPaymentMethodService;

import java.util.List;

public class PaymentMethodService implements IPaymentMethodService {

    private final PaymentMethodService paymentMethodDao;

    public PaymentMethodService(PaymentMethodService paymentMethodDao) {
        this.paymentMethodDao = paymentMethodDao;
    }

    @Override
    public PaymentMethod get(long id) {
        return paymentMethodDao.get(id);
    }

    @Override
    public long save(PaymentMethod paymentMethod) {
        return paymentMethodDao.save(paymentMethod);
    }

    @Override
    public void update(PaymentMethod paymentMethod) {
        paymentMethodDao.update(paymentMethod);
    }

    @Override
    public void delete(PaymentMethod paymentMethod) {
        paymentMethodDao.delete(paymentMethod);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodDao.getAll();
    }
}
