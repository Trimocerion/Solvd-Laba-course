package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.Supplier;

@Mapper
public interface ISupplierMapper extends IMapper<Supplier> {
}
