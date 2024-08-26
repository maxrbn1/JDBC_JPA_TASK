package overridetech.jdbc.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import overridetech.jdbc.jpa.model.User;
import overridetech.jdbc.jpa.dao.*;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {

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
