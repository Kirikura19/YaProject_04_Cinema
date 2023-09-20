package ru.kirikura.yaproject_05_cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kirikura.yaproject_05_cinema.controller.FilmController;
import ru.kirikura.yaproject_05_cinema.controller.UserController;
import ru.kirikura.yaproject_05_cinema.service.FilmService;
import ru.kirikura.yaproject_05_cinema.service.UserService;
import ru.kirikura.yaproject_05_cinema.storage.film.InMemoryFilmStorage;
import ru.kirikura.yaproject_05_cinema.storage.user.InMemoryUserStorage;

@RestControllerAdvice(assignableTypes = {FilmController.class, UserController.class,
        UserService.class, FilmService.class,
        InMemoryFilmStorage.class, InMemoryUserStorage.class})
public class ErrorHandler {

    //HttpRequestMethodNotSupportedException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String handlerOfValidationException(final ValidationException e) {
        return String.format("Ошибка. %s", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public String handlerOfObjectNotFoundException(final ObjectNotFoundException e) {
        return String.format("Ошибка. %s", e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerExceptions(final Exception e) {
        return String.format("Ошибка. %s", e.getMessage());
    }

}
