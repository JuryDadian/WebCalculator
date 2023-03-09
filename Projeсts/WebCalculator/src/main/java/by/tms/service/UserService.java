package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InJDBCUserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
private static final InJDBCUserStorage jdbcUserStorage = new InJDBCUserStorage();
    public void create(User user) {
    jdbcUserStorage.save(user);
    }

    public Optional<User> findUser(String userName) {
        return jdbcUserStorage.findByUserName(userName);
    }

    public static List<User> findAll() {
        return jdbcUserStorage.findAll();
    }


    public static List<User> deleteUser(String userName) {
        jdbcUserStorage.deleteByUserName(userName);
        return new ArrayList<>();
    }

    public static void deleteHistory() {
        jdbcUserStorage.removeStorage();
    }
}
