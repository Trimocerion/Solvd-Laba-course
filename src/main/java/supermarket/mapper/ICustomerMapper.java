package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.Customer;

@Mapper
public interface ICustomerMapper extends IMapper<Customer> {
}
