package ru.fiarr4ik.restapiauth.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

    @Schema(
            name = "userDTO"
    )
    @Getter
    @Setter
    public class UserDTO {

        @NotNull(
                message = "Поле имени не должно быть пустым"
        )
        @JsonProperty
        private String username;

        @NotNull(
                message = "Поле почты не должно быть пустым"
        )
        @JsonProperty
        private String email;

        @NotNull(
                message = "Поле возраста не должно быть пустым"
        )
        @JsonProperty
        private int age;

        @NotNull(
                message = "Поле пароля не должно быть пустым"
        )
        @JsonProperty
        private String password;
    }
