package ru.kirikura.yaproject_05_cinema.model;

import javax.validation.constraints.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private int id;
    @Email
    private String email;
    @NotBlank
    private String login;
    private String name;
    @NotBlank
    private LocalDate birthday;
    private Set<Integer> friends = new HashSet<>();
}


