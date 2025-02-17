package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import supermarket.model.Product;
import java.util.List;

@Mapper
public interface IProductMapper extends IMapper<Product> {
    List<Product> findByCategory(@Param("categoryId") long categoryId);
}
