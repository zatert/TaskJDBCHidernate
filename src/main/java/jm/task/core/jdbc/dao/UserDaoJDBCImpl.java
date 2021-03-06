package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//create read update delete
public class UserDaoJDBCImpl implements UserDao {
//IF NOT EXISTS
    private final String CREATE_TAB = "CREATE TABLE IF NOT EXISTS users2 (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NULL, `lastname` VARCHAR(45) NULL, `age` INT NULL,PRIMARY KEY (`id`));";
    private final String DROP_TAB = "DROP TABLE IF EXISTS users2;";
    private final String INSERT_USER = "";
    private final String CLEAR_TAB = "TRUNCATE TABLE users2";
    private static final String GET_ALL = "SELECT * FROM users2";
    public UserDaoJDBCImpl() {}
    Util util = new Util();



//id, name, lastname, age
    public void createUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute(CREATE_TAB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute(DROP_TAB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("INSERT INTO users2 (name, lastname, age) VALUES ('"+name+"', '"+lastName+"', '"+age+"');");
            System.out.println("User с именем "+name+" добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM users2 WHERE id = '"+id+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute(CLEAR_TAB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
