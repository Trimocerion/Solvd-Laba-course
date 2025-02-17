package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.PaymentMethod;

@Mapper
public interface IPaymentMethodMapper extends IMapper<PaymentMethod> {
}
