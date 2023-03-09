package by.tms.storage;

import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserStorage {
    void save(User user);

    Optional<User> findByUserName(String userName);

    void deleteByUserName(String userName);

    List<User> findAll();

    void removeStorage();
}
