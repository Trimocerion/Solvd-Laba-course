package supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;
import supermarket.model.User;

@Mapper
public interface IUserMapper extends IMapper<User> {
}
