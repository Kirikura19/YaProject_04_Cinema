package ru.kirikura.yaproject_05_cinema.storage.user;

import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.Map;

public interface UserStorage {
    Map<Integer, User> findAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    void deleteAllUsers();

}
