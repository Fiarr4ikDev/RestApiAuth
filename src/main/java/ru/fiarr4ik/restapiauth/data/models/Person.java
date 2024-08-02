package ru.fiarr4ik.restapiauth.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @Entity
    @Table(
            name = "Person"
    )
    public class Person {

        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        @Column(
                name = "id"
        )
        private int id;

        @NotEmpty(
                message = "Имя не должно быть пустым"
        )
        @Size(
                min = 2,
                max = 100,
                message = "Имя должно быть от 2 до 100 символов длиной"
        )
        @Column(
                name = "username"
        )
        private String username;

        @Min(
                value = 1900,
                message = "Год рождения должен быть больше, чем 1900"
        )
        @Column(
                name = "year_of_birth"
        )
        private int yearOfBirth;

        @Column(
                name = "password"
        )
        private String password;

        @Column(
                name = "role"
        )
        private String role;
    }