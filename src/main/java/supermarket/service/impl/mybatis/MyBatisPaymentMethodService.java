package supermarket.service.impl.mybatis;

import supermarket.mapper.IPaymentMethodMapper;
import supermarket.model.PaymentMethod;
import supermarket.service.IPaymentMethodService;

import java.util.List;

public class MyBatisPaymentMethodService implements IPaymentMethodService {

    private final IPaymentMethodMapper paymentMethodMapper;

    public MyBatisPaymentMethodService(IPaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodMapper = paymentMethodMapper;
    }


    @Override
    public PaymentMethod get(long id) {
        return paymentMethodMapper.get(id);
    }

    @Override
    public long save(PaymentMethod paymentMethod) {
        return paymentMethodMapper.save(paymentMethod);
    }

    @Override
    public void update(PaymentMethod paymentMethod) {
        paymentMethodMapper.update(paymentMethod);
    }

    @Override
    public void delete(PaymentMethod paymentMethod) {
        paymentMethodMapper.delete(paymentMethod.getPaymentId());
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodMapper.getAll();
    }
}
