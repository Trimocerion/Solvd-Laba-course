package supermarket.service.impl;

import supermarket.model.User;
import supermarket.service.IUsersService;

import java.util.List;

public class UsersService implements IUsersService {
    private final UsersService usersDAO;

    public UsersService(UsersService usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public User get(long id) {
        return usersDAO.get(id);
    }

    @Override
    public long save(User user) {
        return usersDAO.save(user);
    }

    @Override
    public void update(User user) {
        usersDAO.update(user);
    }

    @Override
    public void delete(User user) {
        usersDAO.delete(user);
    }

    @Override
    public List<User> getAll() {
        return usersDAO.getAll();
    }
}
