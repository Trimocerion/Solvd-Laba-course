package supermarket.service.impl;

import supermarket.model.Roles;
import supermarket.service.IRolesService;

import java.util.List;

public class RolesService implements IRolesService {

    private final RolesService rolesDAO;

    public RolesService(RolesService rolesDAO) {
        this.rolesDAO = rolesDAO;
    }

    @Override
    public Roles get(long id) {
        return rolesDAO.get(id);
    }

    @Override
    public long save(Roles roles) {
        return rolesDAO.save(roles);
    }

    @Override
    public void update(Roles roles) {
        rolesDAO.update(roles);
    }

    @Override
    public void delete(Roles roles) {
        rolesDAO.delete(roles);
    }

    @Override
    public List<Roles> getAll() {
        return rolesDAO.getAll();
    }
}
