package ru.fiarr4ik.restapiauth.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    /**
     * <h1> Сущность пользователя. </h1>
     */
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(
            name = "person"
    )
    public class Person {

        /**
         * Уникальный id пользователя типа {@link Long}.
         * <p> Параметры поля: </p>
         * <p> Не пустое. </p>
         */
        @Column(
                name = "id",
                nullable = false
        )
        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long id;

        /**
         * Имя пользователя.
         * <p> Параметры поля: </p>
         * <p> Не пустое. </p>
         */
        @Column(
                name = "username",
                nullable = false
        )
        private String username;

        /**
         * Почта пользователя.
         * <p> Параметры поля: </p>
         * <p> Не пустое, уникальное. </p>
         */
        @Column(
                name = "mail",
                nullable = false,
                unique = true
        )
        private String mail;

        /**
         * Пароль пользователя.
         * <p> Параметры поля: </p>
         * <p> Не пустое. </p>
         */
        @Column(
                name = "password",
                nullable = false
        )
        private String password;

        /**
         * Роль человека.
         * <p> Параметры поля: </p>
         * <p> Присоединяется поле {@link Role#getId()}. </p>
         * <p> Не пустое. </p>
         */
        @ManyToOne
        @JoinColumn(
                name = "role_id",
                referencedColumnName = "id",
                nullable = false
        )
        private Role role;

    }
