package ru.kirikura.yaproject_05_cinema.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.Film;
import ru.kirikura.yaproject_05_cinema.service.validation.FilmVaidation;
import ru.kirikura.yaproject_05_cinema.service.validation.UserValidation;
import ru.kirikura.yaproject_05_cinema.storage.film.FilmStorage;
import ru.kirikura.yaproject_05_cinema.storage.user.InMemoryUserStorage;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class FilmService {
    FilmStorage filmStorage;
    InMemoryUserStorage userStorage;
    FilmVaidation filmVaidation;
    UserValidation userValidation;

    public Map<Integer, Film> findAllFilms() {
        return filmStorage.findAllFilms();
    }

    public Film addFilm(Film film) throws ValidationException {
        filmVaidation.checkIsFilmDataCorrect(film);
        return filmStorage.addFilm(film);
    }

    public Film updateFilm(Film film) throws ObjectNotFoundException, ValidationException {
        filmVaidation.checkIsFilmDataCorrect(film);
        filmVaidation.checkIsFilmExists(filmStorage, film.getId());
        return filmStorage.updateFilm(film);
    }

    public Film getFilmById(int id) throws ObjectNotFoundException {
        filmVaidation.checkIsFilmExists(filmStorage, id);
        return filmStorage.getFilmById(id);
    }

    public void deleteUserById(int id) throws ObjectNotFoundException {
        filmVaidation.checkIsFilmExists(filmStorage, id);
        filmStorage.deleteFilmById(id);
    }

    public void deleteAllFilms() {
        filmStorage.deleteAllFilms();
    }

    public void addLike(int postId, int userId) throws ObjectNotFoundException {
        filmVaidation.checkIsFilmExists(filmStorage, postId);
        userValidation.checkIsUserExists(userStorage, userId);
        filmStorage.addLike(postId, userId);
    }
    public void removeLike(int postId, int userId) throws ObjectNotFoundException {
        filmVaidation.checkIsFilmExists(filmStorage, postId);
        userValidation.checkIsUserExists(userStorage, userId);
        filmStorage.removeLike(postId, userId);
    }

    public ArrayList<Film> findTopFilms(Integer count) {
        if(count == null) {
            count = 10;
        }
        return filmStorage.findTopFilms(count);
    }

}
