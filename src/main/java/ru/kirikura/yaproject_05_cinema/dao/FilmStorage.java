package ru.kirikura.yaproject_05_cinema.dao;

import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmStorage {
    Optional<List<Film>> findAllFilms();
    Optional<Film> addFilm(Film film);
    Optional<Film> updateFilm(Film film);
    Optional<Film> getFilmById(int id);
    void deleteFilmById(int id);
    void deleteAllFilms();
    void addLike(int postId, int userId);
    void removeLike(int postId, int userId);
    Optional<List<Film>> findTopFilms(int x);
}