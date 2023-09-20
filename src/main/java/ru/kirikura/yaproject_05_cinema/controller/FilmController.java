package ru.kirikura.yaproject_05_cinema.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.Film;
import ru.kirikura.yaproject_05_cinema.service.FilmService;

import java.util.Map;


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
    public Map<Integer, Film> findAllFilms() {
        return filmService.findAllFilms();
    }
    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) throws ValidationException {
        return filmService.addFilm(film);
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) throws ValidationException {
        return filmService.updateFilm(film);
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable int id) throws ValidationException {
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) throws ValidationException {
        filmService.deleteUserById(id);
    }

    @DeleteMapping()
    public void deleteAllFilms() {
        filmService.deleteAllFilms();
    }
}
