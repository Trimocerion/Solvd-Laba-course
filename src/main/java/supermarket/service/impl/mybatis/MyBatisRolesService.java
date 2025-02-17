package supermarket.service.impl.mybatis;

import supermarket.mapper.IRoleMapper;
import supermarket.model.Role;

import java.util.List;

public class MyBatisRolesService implements IRoleMapper {

    private final IRoleMapper roleMapper;

    public MyBatisRolesService(IRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Role get(long id) {
        return roleMapper.get(id);
    }

    @Override
    public long save(Role entity) {
        return roleMapper.save(entity);
    }

    @Override
    public void update(Role entity) {
        roleMapper.update(entity);
    }

    @Override
    public void delete(long id) {
        roleMapper.delete(id);
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }
}
