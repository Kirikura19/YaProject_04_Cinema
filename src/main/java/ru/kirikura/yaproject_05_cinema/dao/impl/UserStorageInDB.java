package ru.kirikura.yaproject_05_cinema.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.dao.UserStorage;
import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserStorageInDB implements UserStorage {

    @Override
    public Optional<List<User>> findAllUsers() {
        return Optional.empty();
    }

    @Override
    public Optional<User> addUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public void addFriend(int userId, int friendId) {

    }

    @Override
    public void removeFriend(int userId, int friendId) {

    }

    @Override
    public Optional<List<User>> findAllFriends(int userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> findAllSameFriends(int userId, int anotherUserId) {
        return Optional.empty();
    }
}
