package ru.kirikura.yaproject_05_cinema.dao;

import ru.kirikura.yaproject_05_cinema.model.Film;

import java.util.List;

public interface FilmStorage {
    List<Film> findAllFilms();
    Film addFilm(Film film);
    Film updateFilm(Film film);
    Film getFilmById(int id);
    void deleteFilmById(int id);
    void deleteAllFilms();
    void addLike(int postId, int userId);
    void removeLike(int postId, int userId);
    List<Film> findTopFilms(int x);
}