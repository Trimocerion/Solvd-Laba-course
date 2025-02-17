package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.ProductCategories;
import java.util.List;

@Mapper
public interface IProductCategoryMapper extends IMapper<ProductCategories> {
}
