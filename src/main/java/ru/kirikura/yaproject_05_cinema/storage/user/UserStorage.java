package ru.kirikura.yaproject_05_cinema.storage.user;

import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.ArrayList;
import java.util.Map;

public interface UserStorage {
    Map<Integer, User> findAllUsers();
    User addUser(User user);
    User updateUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
    void deleteAllUsers();
    void addFriend(int userId, int friendId);
    void removeFriend(int userId, int friendId);
    ArrayList<User> findAllFriends(int userId);
    ArrayList<User> findAllSameFriends(int userId, int anotherUserId);
}
