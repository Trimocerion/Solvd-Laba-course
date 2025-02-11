package supermarket.service.impl;

import supermarket.model.Role;
import supermarket.service.IRolesService;

import java.util.List;

public class RolesService implements IRolesService {

    private final RolesService rolesDAO;

    public RolesService(RolesService rolesDAO) {
        this.rolesDAO = rolesDAO;
    }

    @Override
    public Role get(long id) {
        return rolesDAO.get(id);
    }

    @Override
    public long save(Role role) {
        return rolesDAO.save(role);
    }

    @Override
    public void update(Role role) {
        rolesDAO.update(role);
    }

    @Override
    public void delete(Role role) {
        rolesDAO.delete(role);
    }

    @Override
    public List<Role> getAll() {
        return rolesDAO.getAll();
    }
}
