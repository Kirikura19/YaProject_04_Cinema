package ru.kirikura.yaproject_05_cinema.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.User;
import ru.kirikura.yaproject_05_cinema.service.UserService;

import javax.validation.Valid;
import java.util.List;
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
    public List<User> findAllUsers() throws ObjectNotFoundException {
        return userService.findAllUsers();
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) throws ValidationException {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) throws ValidationException, ObjectNotFoundException {
        return userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws ObjectNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) throws ObjectNotFoundException {
        userService.deleteUserById(id);
    }

    @DeleteMapping()
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @PutMapping("/{id}/friends/{friendId}")
    public void addFriend(@PathVariable int id, @PathVariable int friendId) throws ObjectNotFoundException {
        userService.addFriend(id, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public void removeFriend(@PathVariable int id, @PathVariable int friendId) throws ObjectNotFoundException {
        userService.removeFriend(id, friendId);
    }

    @GetMapping("/{id}/friend")
    public List<User> findAllFriend(@PathVariable int id) throws ObjectNotFoundException {
        return userService.findAllFriends(id);
    }

    @GetMapping("/{id}/friend/common/{otherId}")
    public List<User> findAllSameFriends(@PathVariable int id, @PathVariable int otherId) throws ObjectNotFoundException {
        return userService.findAllSameFriends(id, otherId);
    }
}