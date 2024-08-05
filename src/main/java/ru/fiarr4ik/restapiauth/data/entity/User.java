package ru.fiarr4ik.restapiauth.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fiarr4ik.restapiauth.enums.ERole;

    @Entity
    @Data
    @NoArgsConstructor
    @Table(
            name = "app_user"
    )
    public class User {

        @Column(
                name = "user_id"
        )
        @Id @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long id;

        @Column(
                name = "username"
        )
        private String username;

        @Column(
                name = "email"
        )
        private String email;

        @Column(
                name = "age"
        )
        private int age;

        @Column(
                name = "password"
        )
        private String password;

        @Column(
                name = "user_role"
        )
        @Enumerated(
                value = EnumType.STRING
        )
        private ERole eRole;
    }
