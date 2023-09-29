package ru.kirikura.yaproject_05_cinema.service.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.User;
import ru.kirikura.yaproject_05_cinema.dao.UserStorage;

import java.time.LocalDate;

@Slf4j
@Component
public class UserValidation {

    public void checkIsUsersEmpty(UserStorage userStorage) throws ObjectNotFoundException {
        if(userStorage.findAllUsers().isEmpty()) {
            throw new ObjectNotFoundException("Список пользователей пустой.");
        }
    }

    public void checkIsUserExists(UserStorage userStorage, int id) throws ObjectNotFoundException {

        if(userStorage.findAllUsers().stream()
                .noneMatch(item -> item.getId() == id)) {
            throw new ObjectNotFoundException("Указанного пользователя не существует.");

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