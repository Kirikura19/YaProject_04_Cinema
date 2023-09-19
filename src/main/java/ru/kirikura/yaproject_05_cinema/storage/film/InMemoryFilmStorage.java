package ru.kirikura.yaproject_05_cinema.storage.film;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage{
    private final Map<Integer, Film> films = new HashMap<>();
    @Override
    public Map<Integer, Film> findAllFilms() {
        log.info("Получен список всех фильмов.");
        return films;
    }

    @Override
    public Film addFilm(Film film) {
        films.put(film.getId(), film);
        log.info("Добавлен новый фильм.");
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        films.put(film.getId(), film);
        log.info("Фильм обновлен.");
        return film;
    }

    @Override
    public Film getFilmById(int id) {
        log.info("Получен фильм с Id: "+id+".");
        return films.get(id);
    }

    @Override
    public void deleteFilmById(int id) {
        films.remove(id);
        log.info("Удален фильм с Id: "+id+".");
    }

    @Override
    public void deleteAllFilms() {
        films.clear();
        log.info("Все фильмы были удалены");
    }
}
