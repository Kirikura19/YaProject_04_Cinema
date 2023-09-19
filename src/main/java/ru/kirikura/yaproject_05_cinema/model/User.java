package ru.kirikura.yaproject_05_cinema.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private static int identificator = 0;
    private int id = setId();
    @Email
    private String email;
    @NotBlank
    private String login;
    private String name;
    @NotBlank
    private LocalDate birthday;
    public int setId() {
        return ++identificator;
    }
}


