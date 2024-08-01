package ru.fiarr4ik.restapiauth.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    @Schema(
            name = "DTO ролей пользователей."
    )
    public class RoleDTO {

        @JsonProperty
        private String roleName;

    }
