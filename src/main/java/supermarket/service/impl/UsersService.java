package supermarket.service.impl;

import supermarket.model.Users;
import supermarket.service.IUsersService;

import java.util.List;

public class UsersService implements IUsersService {
    private final UsersService usersDAO;

    public UsersService(UsersService usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public Users get(long id) {
        return usersDAO.get(id);
    }

    @Override
    public long save(Users users) {
        return usersDAO.save(users);
    }

    @Override
    public void update(Users users) {
        usersDAO.update(users);
    }

    @Override
    public void delete(Users users) {
        usersDAO.delete(users);
    }

    @Override
    public List<Users> getAll() {
        return usersDAO.getAll();
    }
}
