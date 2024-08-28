package overridetech.jdbc.jpa.dao;

import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
       Util.runStatement("create table User (\n" +
               "id bigint not null auto_increment, \n" +
               "age tinyint,\n" +
               "lastName varchar(255), \n" +
               "name varchar(255),\n" +
               "primary key (id) \n" +
               " ) engine=InnoDB;");
    }

    public void dropUsersTable() {
        Util.runStatement("drop table if exists User;");
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
