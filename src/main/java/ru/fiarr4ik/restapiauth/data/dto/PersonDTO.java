package ru.fiarr4ik.restapiauth.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    @Schema(
            name = "DTO для пользователей."
    )
    public class PersonDTO {

        @JsonProperty
        @NotEmpty(
                message = "Поле username не должно быть пустым"
        )
        @Size(
                min = 2,
                max = 30,
                message = "Имя пользователя должно быть от 2 до 30 символов"
        )
        private String username;

        @JsonProperty
        @NotEmpty(
                message = "Поле mail не должно быть пустым"
        )
        @Email(
                message = "Поле не соответствует стандарту mail"
        )
        private String mail;

        @JsonProperty
        @NotEmpty(
                message = "Поле password не должно быть пустым"
        )
        @Size(
                min = 8,
                message = "Пароль должен состоять минимум из 8 символов"
        )
        private String password;

    }
