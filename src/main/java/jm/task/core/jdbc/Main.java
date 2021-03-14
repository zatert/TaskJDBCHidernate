package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        User user = new User("Sidr","Petrovich",(byte)80);
        userService.saveUser("Sidr", "Petrovich",(byte)80);
        userService.saveUser("Bronislav", "Petkun",(byte)100);
        userService.saveUser("Zinaida", "Davydova",(byte)127);
        userService.saveUser("Leonid", "Mkrtchan",(byte)12);

        List<User> list = userService.getAllUsers();
        for(User user1 : list) {
            System.out.println(user1);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
