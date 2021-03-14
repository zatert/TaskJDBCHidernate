package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDAO =  new UserDaoHibernateImpl(); //new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDAO.createUsersTable();
    }

    public void dropUsersTable() {
        userDAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDAO.saveUser(name,lastName, (byte) age);
    }

    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }

    public void cleanUsersTable() {
        userDAO.cleanUsersTable();
    }
}
