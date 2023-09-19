package ru.kirikura.yaproject_05_cinema.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.User;
import ru.kirikura.yaproject_05_cinema.storage.user.InMemoryUserStorage;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Service
public class UserService {
    InMemoryUserStorage inMemoryUserStorage;

    @Autowired
    public UserService(InMemoryUserStorage inMemoryUserStorage) {
        this.inMemoryUserStorage = inMemoryUserStorage;
    }
    public Map<Integer, User> findAllUsers() {
        return inMemoryUserStorage.findAllUsers();
    }
    public User addUser(User user) throws ValidationException {
        checkIsUserDataCorrect(user);
        return inMemoryUserStorage.addUser(user);
    }

    public User updateUser(User user) throws ValidationException {
        checkIsUserDataCorrect(user);
        checkIsFilmExists(user.getId());
        return inMemoryUserStorage.updateUser(user);
    }

    public User getUserById(int id) throws ValidationException {
        checkIsFilmExists(id);
        return inMemoryUserStorage.getUserById(id);
    }

    public void deleteUserById(int id) throws ValidationException {
        checkIsFilmExists(id);
        inMemoryUserStorage.deleteUserById(id);
    }

    public void deleteAllUsers() {
        inMemoryUserStorage.deleteAllUsers();
    }

    public void checkIsFilmExists(int id) throws ValidationException {
        if(!inMemoryUserStorage.findAllUsers().containsKey(id)) {
            throw new ValidationException("Указанного пользователя не существует.");
        }
    }

    public void checkIsUserDataCorrect(User newUser) throws ValidationException {
        if (newUser.getLogin().contains(" ")) {
            log.info("Указан некорректный login");
            throw new ValidationException("Указан некорректный login");
        } else if (newUser.getBirthday().isAfter(LocalDate.now())) {
            log.info("Указана некорректная дата рождения");
            throw new ValidationException("Указана некорректная дата рождения");
        }
        if (newUser.getName().isBlank()) {
            newUser.setName(newUser.getLogin());
        }
    }

}
