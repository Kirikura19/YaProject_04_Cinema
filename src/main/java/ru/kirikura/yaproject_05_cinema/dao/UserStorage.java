package ru.kirikura.yaproject_05_cinema.dao;

import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.List;
import java.util.Optional;

public interface UserStorage {
    Optional<List<User>> findAllUsers();
    Optional<User> addUser(User user);
    Optional<User> updateUser(User user);
    Optional<User> getUserById(int id);
    void deleteUserById(int id);
    void deleteAllUsers();
    void addFriend(int userId, int friendId);
    void removeFriend(int userId, int friendId);
    Optional<List<User>> findAllFriends(int userId);
    Optional<List<User>> findAllSameFriends(int userId, int anotherUserId);
}