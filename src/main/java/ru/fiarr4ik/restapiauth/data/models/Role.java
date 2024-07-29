package ru.fiarr4ik.restapiauth.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    /**
     * <h1> Сущность роли человека. </h1>
     */
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(
            name = "role"
    )
    public class Role {

        /**
         * Уникальный идентификатор роли типа {@link Long}.
         * <p> Параметры поля: </p>
         * <p> Не пустое. </p>
         */
        @Column(
                name = "id",
                nullable = false
        )
        @Id @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        private Long id;

        /**
         * Название роли.
         * <p> Параметры поля: </p>
         * <p> Не пустое. </p>
         */
        @Column(
                name = "role_name",
                nullable = false
        )
        private String roleName;

    }
