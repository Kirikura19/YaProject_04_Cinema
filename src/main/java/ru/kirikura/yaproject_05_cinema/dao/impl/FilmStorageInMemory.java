package ru.kirikura.yaproject_05_cinema.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.dao.FilmStorage;
import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.*;

@Slf4j
@Component
public class FilmStorageInMemory implements FilmStorage {
    private final List<Film> films = new ArrayList<>();
    private static int countId;
    @Override
    public List<Film> findAllFilms() {
        log.info("Получен список всех фильмов.");
        return films;
    }

    @Override
    public Film addFilm(Film film) {
        countId++;
        film.setId(countId);
        films.add(film);
        log.info("Добавлен новый фильм с Id "+ countId);
        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        films.add(film);
        log.info("Фильм "+film.getId()+" обновлен.");
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

    @Override
    public void addLike(int postId, int userId) {
        films.get(postId).getLikes().add(userId);
        log.info("К фильму "+postId+"был поставлен лайк пользователем"+userId);
    }

    @Override
    public void removeLike(int postId, int userId) {
        films.get(postId).getLikes().remove(userId);
        log.info("К фильму "+postId+"был убран лайк пользователем"+userId);
    }

    @Override
    public List<Film> findTopFilms(int count) {
        List<Film> topFilms = new ArrayList<>(films);
        topFilms.sort(Comparator.comparing(x -> x.getLikes().size()));
        if(!(topFilms.size() <= count)) {
            topFilms.subList(count, topFilms.size()).clear();
        }
        return topFilms;
    }
}