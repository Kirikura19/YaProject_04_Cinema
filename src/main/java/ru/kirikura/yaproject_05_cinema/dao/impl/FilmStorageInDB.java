package ru.kirikura.yaproject_05_cinema.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_cinema.dao.FilmStorage;
import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class FilmStorageInDB implements FilmStorage {
    @Override
    public Optional<List<Film>> findAllFilms() {
        return Optional.empty();
    }

    @Override
    public Optional<Film> addFilm(Film film) {
        return Optional.empty();
    }

    @Override
    public Optional<Film> updateFilm(Film film) {
        return Optional.empty();
    }

    @Override
    public Optional<Film> getFilmById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteFilmById(int id) {

    }

    @Override
    public void deleteAllFilms() {

    }

    @Override
    public void addLike(int postId, int userId) {

    }

    @Override
    public void removeLike(int postId, int userId) {

    }

    @Override
    public Optional<List<Film>> findTopFilms(int x) {
        return Optional.empty();
    }
}
