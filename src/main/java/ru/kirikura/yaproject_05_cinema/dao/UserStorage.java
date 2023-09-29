package ru.kirikura.yaproject_05_cinema.dao;

import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.List;

public interface UserStorage {
    List<User> findAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    void deleteAllUsers();
    void addFriend(int userId, int friendId);
    void removeFriend(int userId, int friendId);
    List<User> findAllFriends(int userId);
    List<User> findAllSameFriends(int userId, int anotherUserId);
}