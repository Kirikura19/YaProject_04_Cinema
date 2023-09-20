package ru.kirikura.yaproject_05_cinema.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.User;
import ru.kirikura.yaproject_05_cinema.service.UserService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Map<Integer, User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) throws ValidationException {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) throws ValidationException {
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws ValidationException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) throws ValidationException {
        userService.deleteUserById(id);
    }

    @DeleteMapping()
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }
}
