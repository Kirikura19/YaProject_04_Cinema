package ru.kirikura.yaproject_05_cinema.storage.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Integer, User> users = new HashMap<>();

    private static int countId;
    @Override
    public Map<Integer, User> findAllUsers() {
        log.info("Получен список всех пользователей");
        return users;
    }

    @Override
    public User addUser(User user) {
        countId++;
        user.setId(countId);
        users.put(user.getId(), user);
        log.info("Добавлен новый пользователь с Id "+ countId);
        return user;
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getId(), user);
        log.info("Пользователь "+user.getId()+" обновлен.");
        return user;
    }

    @Override
    public User getUserById(int id) {
        log.info("Получен пользователь с Id: "+id+".");
        return users.get(id);
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
    public ArrayList<User> findAllFriends(int userId) {
        ArrayList<User> allFriends = new ArrayList<>();
        for(Integer i : users.get(userId).getFriends()) {
            allFriends.add(users.get(i));
        }
        log.info("Выведен список всех друзей с Id "+userId);
        return allFriends;
    }

    @Override
    public ArrayList<User> findAllSameFriends(int userId, int anotherUserId) {
        ArrayList<User> sameFriend = new ArrayList<>();
        for(Integer i : users.get(userId).getFriends()) {
            if(users.get(anotherUserId).getFriends().contains(i)){
                sameFriend.add(users.get(i));
            }
        }
        return sameFriend;
    }
}
