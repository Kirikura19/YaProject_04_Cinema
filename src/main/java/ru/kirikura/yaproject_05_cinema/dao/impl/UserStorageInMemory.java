package ru.kirikura.yaproject_05_cinema.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.dao.UserStorage;
import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserStorageInMemory implements UserStorage {
    private final List<User> users = new ArrayList<>();

    private static int countId;
    @Override
    public Optional<List<User>> findAllUsers() {
        log.info("Получен список всех пользователей");
        return Optional.of(users);
    }

    @Override
    public Optional<User> addUser(User user) {
        countId++;
        user.setId(countId);
        users.add(user);
        log.info("Добавлен новый пользователь с Id "+ countId);
        return Optional.of(user);
    }

    @Override
    public Optional<User> updateUser(User user) {
        users.add(user);
        log.info("Пользователь "+user.getId()+" обновлен.");
        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        log.info("Получен пользователь с Id: "+id+".");
        return Optional.of(users.get(id));
    }

    @Override
    public void deleteUserById(int id) {
        users.remove(id);
        log.info("Удален пользователь с Id: "+id+".");
    }

    @Override
    public void deleteAllUsers() {
        users.clear();
        log.info("Все пользователи были удалены");
    }

    @Override
    public void addFriend(int userId, int friendId) {
        users.get(userId).getFriends().add(friendId);
        users.get(friendId).getFriends().add(userId);
        log.info("Пользователь с Id "+userId+"добавил в друзья пользователя с Id "+friendId);
    }

    @Override
    public void removeFriend(int userId, int friendId) {
        users.get(userId).getFriends().remove(friendId);
        users.get(friendId).getFriends().remove(userId);
        log.info("Пользователь с Id "+userId+"удалил из друзей пользователя с Id "+friendId);
    }

    @Override
    public Optional<List<User>> findAllFriends(int userId) {
        ArrayList<User> allFriends = new ArrayList<>();
        for(Integer i : users.get(userId).getFriends()) {
            allFriends.add(users.get(i));
        }
        log.info("Выведен список всех друзей с Id "+userId);
        return Optional.of(allFriends);
    }

    @Override
    public Optional<List<User>> findAllSameFriends(int userId, int anotherUserId) {
        ArrayList<User> sameFriend = new ArrayList<>();
        for(Integer i : users.get(userId).getFriends()) {
            if(users.get(anotherUserId).getFriends().contains(i)){
                sameFriend.add(users.get(i));
            }
        }
        return Optional.of(sameFriend);
    }
}