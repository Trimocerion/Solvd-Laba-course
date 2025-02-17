package supermarket.service.impl.mybatis;

import supermarket.mapper.IUserMapper;
import supermarket.model.User;
import supermarket.service.IUsersService;

import java.util.List;

public class MyBatisUsersService implements IUsersService {

    private final IUserMapper userMapper;

    public MyBatisUsersService(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User get(long id) {
        return userMapper.get(id);
    }

    @Override
    public long save(User user) {
        return userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user.getUserId());
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
