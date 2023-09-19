package ru.kirikura.yaproject_05_cinema.storage.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.model.User;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final Map<Integer, User> users = new HashMap<>();
    @Override
    public  Map<Integer, User> findAllUsers() {
        log.info("Получен список всех пользователей");
        return users;
    }

    @Override
    public User addUser(User user) {
        users.put(user.getId(), user);
        log.info("Добавлен новый пользователь.");
        return user;
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getId(), user);
        log.info("Пользователь обновлен.");
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

}
