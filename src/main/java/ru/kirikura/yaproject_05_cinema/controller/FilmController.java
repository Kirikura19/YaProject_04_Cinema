package ru.kirikura.yaproject_05_cinema.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.Film;
import ru.kirikura.yaproject_05_cinema.service.FilmService;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> findAllFilms() throws ObjectNotFoundException {
        return filmService.findAllFilms();
    }
    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) throws ValidationException {
        return filmService.addFilm(film);
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) throws ObjectNotFoundException, ValidationException {
        return filmService.updateFilm(film);
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable int id) throws ObjectNotFoundException {
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) throws ObjectNotFoundException {
        filmService.deleteUserById(id);
    }

    @DeleteMapping()
    public void deleteAllFilms() {
        filmService.deleteAllFilms();
    }

    @PutMapping("/{id}/like/{userId}")
    public void addLike(@PathVariable int id, @PathVariable int userId) throws ObjectNotFoundException {
        filmService.addLike(id, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public void removeLike(@PathVariable int id, @PathVariable int userId) throws ObjectNotFoundException {
        filmService.removeLike(id, userId);
    }

    @GetMapping("/popular")
    public List<Film> findTopFilms(
            @RequestParam(required = false) Integer count) {
        return filmService.findTopFilms(count);
    }
}