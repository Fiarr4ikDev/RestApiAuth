package ru.fiarr4ik.restapiauth.utils;

import lombok.Getter;
import lombok.Setter;

    /**
     * Класс для исключений пользователей.
     */
    @Getter
    @Setter
    public class PersonErrorResponse {

        private String message;
        private long timestamp;

        public PersonErrorResponse(long timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
