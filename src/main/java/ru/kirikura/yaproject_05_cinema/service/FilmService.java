package ru.kirikura.yaproject_05_cinema.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.Film;
import ru.kirikura.yaproject_05_cinema.storage.film.InMemoryFilmStorage;

import java.time.*;
import java.util.Map;

@Slf4j
@Service
public class FilmService {
    InMemoryFilmStorage inMemoryFilmStorage;
    private final static LocalDate MIN_DATE = LocalDate.parse("1986-01-01");
    @Autowired
    public FilmService(InMemoryFilmStorage inMemoryFilmStorage) {
        this.inMemoryFilmStorage = inMemoryFilmStorage;
    }

    public Map<Integer, Film> findAllFilms() {
        return inMemoryFilmStorage.findAllFilms();
    }

    public Film addFilm(Film film) throws ValidationException {
        checkIsFilmDataCorrect(film);
        return inMemoryFilmStorage.addFilm(film);
    }

    public Film updateFilm(Film film) throws ValidationException {
        checkIsFilmDataCorrect(film);
        checkIsFilmExists(film.getId());
        return inMemoryFilmStorage.updateFilm(film);
    }

    public Film getFilmById(int id) throws ValidationException {
        checkIsFilmExists(id);
        return inMemoryFilmStorage.getFilmById(id);
    }

    public void deleteUserById(int id) throws ValidationException {
        checkIsFilmExists(id);
        inMemoryFilmStorage.deleteFilmById(id);
    }

    public void deleteAllFilms() {
        inMemoryFilmStorage.deleteAllFilms();
    }

    public void checkIsFilmExists(int id) throws ValidationException {
        if(!inMemoryFilmStorage.findAllFilms().containsKey(id)) {
            throw new ValidationException("Указанного фильма не существует.");
        }
    }

    public void checkIsFilmDataCorrect(Film newFilm) throws ValidationException {
        if (newFilm.getName() == null || newFilm.getName().isBlank()) {
            log.info("Не удалось добавить/обновить фильм т.к. не указано название");
            throw new ValidationException("Не указано название фильма");
        } else if (newFilm.getDescription() == null || newFilm.getDescription().length() > 200) {
            log.info("Не удалось добавить/обновить фильм т.к. превышена допустимая длина описания");
            throw new ValidationException("Превышена допустимая длина описания - 200 символов");
        } else if (newFilm.getReleaseDate() == null || newFilm.getReleaseDate().isBefore(MIN_DATE)) {
            log.info("Не удалось добавить/обновить фильм т.к. указана некорректная дата выхода");
            throw new ValidationException("Указана некорректная дата выхода фильма");
        } else if (!(newFilm.getDuration() >= 1)) {
            log.info("Не удалось добавить/обновить фильм т.к. некорректно указана длительность");
            throw new ValidationException("Указана некорректная длительность фильма");
        }
    }
}
