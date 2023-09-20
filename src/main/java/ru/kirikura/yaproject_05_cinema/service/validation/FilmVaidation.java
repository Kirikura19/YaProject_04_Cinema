package ru.kirikura.yaproject_05_cinema.service.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.Film;
import ru.kirikura.yaproject_05_cinema.storage.film.FilmStorage;

import java.time.LocalDate;

@Slf4j
@Component
public class FilmVaidation {

    private final static LocalDate MIN_DATE = LocalDate.parse("1986-01-01");

    public void checkIsFilmExists(FilmStorage filmStorage, int id) throws ObjectNotFoundException {
        if(!filmStorage.findAllFilms().containsKey(id)) {
            throw new ObjectNotFoundException("Указанного фильма не существует.");
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
