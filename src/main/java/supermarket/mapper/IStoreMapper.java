package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.Store;

@Mapper
public interface IStoreMapper extends IMapper<Store> {
}
