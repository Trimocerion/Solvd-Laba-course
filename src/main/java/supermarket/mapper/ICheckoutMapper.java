package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.Checkout;

@Mapper
public interface ICheckoutMapper extends IMapper<Checkout> {
}
